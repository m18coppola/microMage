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
    public static Player player;
   public static Barbarian enemy1;
   public static Troll enemy2;
    Controller controller;
    static ArrayList<FireBall> fireBalls;
    static ArrayList<Axe> axes;
    static ArrayList<Arrow> arrows;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        fireBalls = new ArrayList<FireBall>();
        axes = new ArrayList<Axe>();
        arrows = new ArrayList<Arrow>();
        player = new Player();
        enemy1 = new Barbarian(100,100);
        enemy2 = new Troll(25,25);
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 125, 125);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.input.setInputProcessor(new Controller(player));
    }

    @Override
    public void update(float dt) {
        player.update(dt);
        enemy1.update(dt);
        enemy2.update(dt);
        for (FireBall fireBall : fireBalls) {
            fireBall.update(dt);
        }
        for (Axe axe : axes) {
            axe.update(dt);
        }
        for (Arrow arrow : arrows) {
            arrow.update(dt);
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
        for (Axe axe : axes) {
            batch.draw(axe.getSprite(), axe.getPosition().x, axe.getPosition().y);
        }
        for (Arrow arrow : arrows) {
            arrow.getSprite().setPosition(arrow.getPosition().x, arrow.getPosition().y);
           arrow.getSprite().draw(batch);
        }
        batch.draw(player.getSprite(), player.getPosition().x, player.getPosition().y);
        batch.draw(enemy1.getSprite(), enemy1.getPosition().x, enemy1.getPosition().y);
        batch.draw(enemy2.getSprite(), enemy2.getPosition().x, enemy2.getPosition().y);
        batch.end();
    }

    public static void addFireBall(FireBall f) {
        fireBalls.add(f);
    }

    public static void addAxe(Axe f) {
        axes.add(f);
    }

    public static void addArrow(Arrow f) {
        arrows.add(f);
    }

    @Override
    public void dispose() {
        player.dispose();
        for (FireBall fireBall : fireBalls) {
            fireBall.dispose();
        }
            enemy1.dispose();
            for(Axe axe : axes) {
                axe.dispose();
            }
            enemy2.dispose();
            for(Arrow arrow: arrows) {
                arrow.dispose();
            }
            }
        }


