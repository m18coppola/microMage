package com.project.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {

    protected GameStateManager gsm;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void update(float dt);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();
}
