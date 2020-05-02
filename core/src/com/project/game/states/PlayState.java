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
import com.project.game.entities.tiles.Wall;

import java.util.ArrayList;
import java.util.Timer;

public class PlayState extends State {

    public static OrthographicCamera cam;
    Player player;

    static ArrayList<Spells> projectiles;
    static HealthBar healthBar;
    static ManaBar manaBar;
    static RegenMana regenMana;



    public static Tile[] floors = new Tile[49];

    public PlayState(GameStateManager gsm) {
        super(gsm);
        projectiles = new ArrayList<Spells>();
        player = new Player();
        healthBar = new HealthBar(player);
        healthBar.start();
        manaBar = new ManaBar(player);
        manaBar.start();
        regenMana = new RegenMana(player);
        regenMana.start();
        cam = new OrthographicCamera();
        cam.setToOrtho(false,125 , 125);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.input.setInputProcessor(new Controller(player));


        int i = 0;
        for(int x = 0; x < Math.sqrt(floors.length); x++){
            for (int y = 0; y < Math.sqrt(floors.length); y++){
                if(x == 0 || y == 0 || x == Math.sqrt(floors.length) - 1 || y == Math.sqrt(floors.length) - 1)
                floors[i] = new Wall(x * Tile.DIM * 2, y * Tile.DIM * 2);
                else
                    floors[i] = new Floor(x * Tile.DIM * 2, y * Tile.DIM * 2);
                i++;
            }
        }

    }

    @Override
    public void update(float dt) {
        player.update(dt);
        for(Spells p: projectiles){
            p.update(dt);
        }

    }

    @Override
    public void render(SpriteBatch batch) {

        batch.setProjectionMatrix(cam.combined);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        for(Tile f: floors){
            batch.draw(f.getSprite(), f.getPosition().x, f.getPosition().y,16,16);

        }
        for(Spells p: projectiles){
            batch.draw(p.getSprite(),p.getPosition().x, p.getPosition().y);
        }
        batch.draw(player.getSprite(), player.getPosition().x, player.getPosition().y);
        healthBar.render(batch);
        manaBar.render(batch);
        Game.sr.setProjectionMatrix(cam.combined);
        Game.sr.begin(ShapeRenderer.ShapeType.Line);
        Game.sr.rect(player.hitbox.x,player.hitbox.y,player.hitbox.width,player.hitbox.height);
        for(Tile t: floors){
            if(t instanceof Wall){
                Game.sr.rect(t.hitbox.x,t.hitbox.y,t.hitbox.width,t.hitbox.height);
            }
        }
        Game.sr.end();



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
