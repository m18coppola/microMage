package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
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
/*
the main game state
 */
public class PlayState extends State {



    public static OrthographicCamera cam;
    public static OrthographicCamera UIcam;
    public static Player player;
    public static int score = 0;
    Texture pause;




    public static ArrayList<Spells> projectiles;


    static HealthBar healthBar;
    public static boolean isPaused;
    static ManaBar manaBar;
    static RegenMana regenMana;
    public static int currSpell;
    public static TileMap tileMap;
    public static ArrayList<EnemyProjectiles> enemyProjectiles;
    public static ArrayList<EnemyProjectiles> removedProjectiles;
    public static ArrayList<Enemy> killedEnemies;
    public static ArrayList<Spells> usedProjectiles;
    public static GameStateManager gsm;
    private static boolean alt = true;
    RayCaster rc;


    public static SoundEffect dungeonMusic1 = new SoundEffect(ResourceLoader.loadDungeonMusic1());
    public static SoundEffect dungeonMusic2 = new SoundEffect(ResourceLoader.loadDungeonMusic2());
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    BitmapFont font30;
    GlyphLayout gl;
    boolean gameReady;

    float gameStartTimer = 0;

    /*
    constructs state

    @param gsm the game state manager
     */
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
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Gdx.input.setInputProcessor(new Controller(player));
        pause = new Texture("UI/pause.png");
        isPaused = false;
        enemyProjectiles = new ArrayList<EnemyProjectiles>();

        removedProjectiles = new ArrayList<EnemyProjectiles>();
        killedEnemies = new ArrayList<Enemy>();
        usedProjectiles = new ArrayList<Spells>();

        ArrayList<Wall> walls = new ArrayList<Wall>();
        for(Tile t: tileMap.tiles){
            if(t instanceof Wall){
                walls.add((Wall)t);
            }
        }

        rc = new RayCaster(walls);

        generator = new FreeTypeFontGenerator(Gdx.files.internal("UI/Boxy-Bold.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 8;
        font30 = generator.generateFont(parameter);
        gl = new GlyphLayout();
        gl.setText(font30, "");
        if(alt == true) {
            dungeonMusic1.playSound();
            dungeonMusic1.loop();
        }
        else if(alt == false) {
            dungeonMusic2.playSound();
            dungeonMusic2.loop();
        }
        gameReady = true;
    }
    /*
        creates new level and moves it to the stack
     */
    public static void nextLevel() {
        score++;
        gsm.set(new PlayState(gsm));
    }
    /*
    updates the state

    @param dt the time passed between frames
     */
    @Override
    public void update(float dt) {
        if(gameStartTimer < 1.5f) {
            gameStartTimer += dt;
        }

        if (Player.getHealth() == 0) {
            if(alt == true) {
                dungeonMusic1.stopSound();
            }
            else if(alt == false) {
                dungeonMusic2.stopSound();
            }
            gsm.set(new EndGameState(gsm));
            SoundEffect gameOver = new SoundEffect(ResourceLoader.loadGameOver());
            gameOver.playSound();
        }
        dt = Gdx.graphics.getDeltaTime();
        if(gameStartTimer > 1.0f){

            player.update(dt);
        }
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
    /*
    renders the current state

    @param batch the batch to be used for drawing
     */
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

        rc.update(player.getCenter());
        batch.draw(rc.getShadow(player.getCenter()),0,0,500,500);

        batch.setProjectionMatrix(UIcam.combined);


        batch.draw(pause, 115, 115, 10, 10);
        healthBar.render(batch);
        manaBar.render(batch);
        if(TileMap.enemies.size() > 0) {
            gl.setText(font30, "Enemies Left: " + TileMap.enemies.size());
            font30.draw(batch, gl, 0, 125);
        }
        else {
            gl.setText(font30, "Find the Ladder!");
            font30.draw(batch, gl, 0, 125);
        }
        batch.end();

    }

    /*
    adds player projectile to state

    @param p the projectile
     */
    public static void addProjectile(Spells p) {
        projectiles.add(p);
    }
    /*
    adds enemy projectile to state

    @param f the projectile
     */
    public static void addEnemyProjectile(EnemyProjectiles f) {
        enemyProjectiles.add(f);
    }
    /*
    returns the dungeon's music

    @return the music
     */
    public static SoundEffect getDungeonMusic() {
        if(alt == true) {
            return dungeonMusic1;
        }
        else  {
            return dungeonMusic2;
        }
    }



    /*
    frees the memory allocated by the object
     */
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



