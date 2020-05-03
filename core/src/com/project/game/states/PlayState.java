package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.project.game.Controller;

import com.project.game.HealthBar;
import com.project.game.ManaBar;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.project.game.*;
import com.project.game.entities.FireBall;
import com.project.game.entities.Player;
import com.project.game.entities.Spells;
import com.project.game.entities.tiles.*;

import com.project.game.entities.*;

import java.util.ArrayList;

public class PlayState extends State {

    public static OrthographicCamera cam;
    public static OrthographicCamera UIcam;
    public static Player player;
    public static int score = 0;
    Controller controller;
    Texture pause;




    public static ArrayList<Spells> projectiles;


    static HealthBar healthBar;
    public static boolean isPaused;
    static ManaBar manaBar;
    static RegenMana regenMana;
    public static int currSpell;
    public static SoundEffect currSpellSound;
    public static TileMap tileMap;
    public static ArrayList<EnemyProjectiles> enemyProjectiles;
    public static ArrayList<EnemyProjectiles> removedProjectiles;
    public static ArrayList<Enemy> killedEnemies;
    public static ArrayList<Spells> usedProjectiles;
    public static GameStateManager gsm;
    private static boolean alt = true;
    SoundEffect dungeonMusic = new SoundEffect(ResourceLoader.loadDungeonMusic());

    public PlayState(GameStateManager gsm) {
        super(gsm);
        this.gsm = gsm;
        tileMap = new TileMap(alt);
        alt = !alt;
        projectiles = new ArrayList<Spells>();
        player = new Player(tileMap.playerSpawn.x, tileMap.playerSpawn.y);
        healthBar = new HealthBar(player);
        healthBar.start();
        manaBar = new ManaBar(player);
        manaBar.start();
        regenMana = new RegenMana(player);
        regenMana.start();
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 125, 125);
        UIcam = new OrthographicCamera();
        UIcam.setToOrtho(false, 125, 125);
        Gdx.gl.glClearColor(41f / 255f, 30f / 255f, 49f / 255f, 1);
        if(alt){
            Gdx.gl.glClearColor(49f / 255f, 30f / 255f, 30f / 255f, 1);
        }
        Gdx.input.setInputProcessor(new Controller(player));
        pause = new Texture("UI/pause.png");
        isPaused = false;
        enemyProjectiles = new ArrayList<EnemyProjectiles>();

        removedProjectiles = new ArrayList<EnemyProjectiles>();
        killedEnemies = new ArrayList<Enemy>();
        usedProjectiles = new ArrayList<Spells>();


        dungeonMusic.playSound();

    }

    public static void nextLevel() {
        score++;
        gsm.set(new PlayState(gsm));
    }

    @Override
    public void update(float dt) {
        if (Player.getHealth() == 0) {
            dungeonMusic.dispose();
            gsm.set(new EndGameState(gsm));
            SoundEffect gameOver = new SoundEffect(ResourceLoader.loadGameOver());
            gameOver.playSound();
        }
        dt = Gdx.graphics.getDeltaTime();
        player.update(dt);
        for (Spells p : projectiles) {
            p.update(dt);
        }

        cam.position.set(player.getCenter(), 0);
        cam.update();
        for (EnemyProjectiles ep : enemyProjectiles) {
            ep.update(dt);        }
        for (int i = 0; i < removedProjectiles.size(); i++) {
            enemyProjectiles.remove(removedProjectiles.get(i));
        }

        removedProjectiles = new ArrayList<EnemyProjectiles>();


        for (Enemy enemy : tileMap.enemies) {
            enemy.update(dt);
        }
        for (int i = 0; i < killedEnemies.size(); i++) {
            tileMap.enemies.remove(killedEnemies.get(i));
        }
        killedEnemies = new ArrayList<Enemy>();
        for (int i = 0; i < usedProjectiles.size(); i++) {
            projectiles.remove(usedProjectiles.get(i));
        }
        usedProjectiles =  new ArrayList<Spells>();
    }


    @Override
    public void render(SpriteBatch batch) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(cam.combined);
        for (Tile t : tileMap.tiles) {
            if (t != null)
                if(!(t instanceof Goal) || TileMap.enemies.isEmpty())
                batch.draw(t.getSprite(), t.getPosition().x, t.getPosition().y, 16, 16);
        }

        for (Enemy enemy : tileMap.enemies) {
            batch.draw(enemy.getSprite(), enemy.hitbox.getX(), enemy.hitbox.y);
        }

        for (Spells p : projectiles) {
            batch.draw(p.getSprite(), p.getPosition().x, p.getPosition().y);
        }
        for (EnemyProjectiles ep : enemyProjectiles) {
            ep.getSprite().setPosition(ep.getPosition().x, ep.getPosition().y);
            ep.getSprite().draw(batch);
        }
        batch.draw(player.getSprite(), player.getPosition().x - 5, player.getPosition().y);
        batch.setProjectionMatrix(UIcam.combined);
        batch.draw(pause, 115, 115, 10, 10);
        healthBar.render(batch);
        manaBar.render(batch);
        batch.end();


    }


    public static void addProjectile(Spells p) {
        projectiles.add(p);
    }

    public static void addEnemyProjectile(EnemyProjectiles f) {
        enemyProjectiles.add(f);
    }


    @Override
    public void dispose() {
        player.dispose();

        for (Spells p : projectiles) {
            p.dispose();
        }
        healthBar.dispose();
        pause.dispose();
        manaBar.dispose();

        for (EnemyProjectiles ep : enemyProjectiles) {
            ep.dispose();
        }
    }
}



