package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class EndGameState extends State {

    Texture endGame;
    OrthographicCamera UIcam;

    public EndGameState(GameStateManager gsm){
        super(gsm);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        endGame = new Texture("UI/Game-Over.png");
        UIcam = new OrthographicCamera();
        UIcam.setToOrtho(false, 500, 500);
    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void render(SpriteBatch batch) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(UIcam.combined);
        batch.begin();
        batch.draw(endGame, 250 - endGame.getWidth()/2,250);
        batch.end();
    }

    @Override
    public void dispose() {
        endGame.dispose();
    }
}
