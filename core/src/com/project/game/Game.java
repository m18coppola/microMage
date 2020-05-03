package com.project.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.project.game.entities.FireBall;
import com.project.game.entities.Player;
import com.project.game.states.GameStateManager;
import com.project.game.states.MenuState;
import com.project.game.states.PlayState;

import java.util.ArrayList;
import java.util.Timer;

public class Game extends ApplicationAdapter {
    SpriteBatch batch;
    static GameStateManager gsm;


    @Override
    public void create () {

        batch = new SpriteBatch();
        gsm = new GameStateManager();
        gsm.push(new MenuState(gsm));
    }

    @Override
    public void render () {
        if(!(gsm.peek() instanceof PlayState) || !PlayState.isPaused) {
            gsm.update(Gdx.graphics.getDeltaTime());
            gsm.render(batch);
        }

    }

    @Override
    public void dispose () {
        gsm.dispose();
    }


}
