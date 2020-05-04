package com.project.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*
state abstract class
 */
public abstract class State {

    protected GameStateManager gsm;
    /*
    constructs the state

    @param gsm the game state manager
     */
    protected State(GameStateManager gsm) {
        this.gsm = gsm;
    }
    /*
    updates the state

    @param dt the time passed between frames
     */
    public abstract void update(float dt);
    /*
    renders the current state

    @param batch the batch to be used for drawing
     */
    public abstract void render(SpriteBatch batch);
    /*
    frees the memory allocated by the object
     */
    public abstract void dispose();
}
