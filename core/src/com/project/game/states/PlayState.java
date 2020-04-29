package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.Controller;
import com.project.game.entities.*;

import java.util.ArrayList;

public class PlayState extends State {

    public static OrthographicCamera cam;
    Player player;
    Enemy enemy1;
    Controller controller;
    static ArrayList<FireBall> fireBalls;
    static ArrayList<Axe> axes;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        fireBalls = new ArrayList<FireBall>();
        axes = new ArrayList<Axe>();
        player = new Player();
        enemy1 = new Barbarian();
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 125, 125);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.input.setInputProcessor(new Controller(player));
    }

    @Override
    public void update(float dt) {
        player.update(dt);
        enemy1.update(dt);
        for (FireBall fireBall : fireBalls) {
            fireBall.update(dt);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(cam.combined);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        for (FireBall fireBall : fireBalls) {
            batch.draw(fireBall.getSprite(), fireBall.getPosition().x, fireBall.getPosition().y);
        }
        batch.draw(player.getSprite(), player.getPosition().x, player.getPosition().y);
        batch.draw(enemy1.getSprite(), enemy1.getPosition().x, enemy1.getPosition().y);
        batch.end();
    }

    public static void addFireBall(FireBall f) {
        fireBalls.add(f);
    }

    public static void addAxe(Axe f) {
        axes.add(f);
    }

    @Override
    public void dispose() {
        player.dispose();
        for (FireBall fireBall : fireBalls) {
            fireBall.dispose();
        }
    }
}
