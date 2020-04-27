package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.project.game.Controller;
import com.project.game.HealthBar;
import com.project.game.entities.FireBall;
import com.project.game.entities.Player;
import com.project.game.entities.Spells;

import java.util.ArrayList;

public class PlayState extends State {

    public static OrthographicCamera cam;
    Player player;
    Controller controller;
    Texture pause;
    Texture spell;
    static ArrayList<Spells> projectiles;
    static HealthBar healthBar;
    public static boolean isPaused;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        projectiles = new ArrayList<Spells>();
        player = new Player();
        healthBar = new HealthBar(player);
        healthBar.start();
        cam = new OrthographicCamera();
        cam.setToOrtho(false,125 , 125);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.input.setInputProcessor(new Controller(player));
        pause = new Texture("UI/pause.png");
        spell = new Texture("UI/spell.png");
        isPaused = false;
    }

    @Override
    public void update(float dt) {
        if (isPaused) {
            dt = 0;
        } else {
            dt = Gdx.graphics.getDeltaTime();
            player.update(dt);
            for (Spells p : projectiles) {
                p.update(dt);
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(cam.combined);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(pause, 115,115, 10, 10);
        batch.draw(spell, 115,103, 5 , 5);
        for(Spells p: projectiles){
            batch.draw(p.getSprite(),p.getPosition().x, p.getPosition().y);
        }
        batch.draw(player.getSprite(), player.getPosition().x, player.getPosition().y);
        healthBar.render(batch);

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
        pause.dispose();
        spell.dispose();
    }
}
