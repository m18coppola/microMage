package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.project.game.*;
import com.project.game.entities.FireBall;
import com.project.game.entities.Player;
import com.project.game.entities.Spells;
import com.project.game.entities.tiles.Floor;
import com.project.game.entities.tiles.Tile;
import com.project.game.entities.tiles.TileMap;
import com.project.game.entities.tiles.Wall;

import java.util.ArrayList;
import java.util.Timer;

public class PlayState extends State {

    public static OrthographicCamera cam;
    public static OrthographicCamera UIcam;
    Player player;

    static ArrayList<Spells> projectiles;
    static HealthBar healthBar;
    static ManaBar manaBar;
    static RegenMana regenMana;
    public static TileMap tileMap;




    public PlayState(GameStateManager gsm) {
        super(gsm);
        tileMap = new TileMap();
        projectiles = new ArrayList<Spells>();
        player = new Player(tileMap.playerSpawn.x,tileMap.playerSpawn.y);
        healthBar = new HealthBar(player);
        healthBar.start();
        manaBar = new ManaBar(player);
        manaBar.start();
        regenMana = new RegenMana(player);
        regenMana.start();
        cam = new OrthographicCamera();
        cam.setToOrtho(false,125 , 125);
        UIcam = new OrthographicCamera();
        UIcam.setToOrtho(false,125,125);
        Gdx.gl.glClearColor(41f/255f, 30f/255f, 49f/255f, 1);
        Gdx.input.setInputProcessor(new Controller(player));





    }

    @Override
    public void update(float dt) {
        player.update(dt);
        for(Spells p: projectiles){
            p.update(dt);
        }
        cam.position.set(player.getCenter(),0);
        cam.update();

    }

    @Override
    public void render(SpriteBatch batch) {


        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.setProjectionMatrix(cam.combined);


        for(Tile t: tileMap.tiles){
            if(t != null)
            batch.draw(t.getSprite(),t.getPosition().x,t.getPosition().y,16,16);
        }

        for(Spells p: projectiles){
            batch.draw(p.getSprite(),p.getPosition().x, p.getPosition().y);
        }
        batch.draw(player.getSprite(), player.getPosition().x - 5, player.getPosition().y);
        batch.setProjectionMatrix(UIcam.combined);
        healthBar.render(batch);
        manaBar.render(batch);





        batch.end();


    }

    public static void addProjectile(Spells p){ projectiles.add(p);
    }

    @Override
    public void dispose() {
        player.dispose();
        for(Spells p: projectiles){
            p.dispose();
        }
        healthBar.dispose();
        manaBar.dispose();

    }
}
