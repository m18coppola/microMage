package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.ResourceLoader;
import com.project.game.SoundEffect;
import com.project.game.states.MenuState;

/*
the spell instruction screen state
 */
public class SpellsState extends State {
    Texture spells;
    /*
    constructs state

    @param gsm the game state manager
     */
    public SpellsState(GameStateManager gsm) {
        super(gsm);
        spells = new Texture("UI/spells.png");
    }
    /*
    updates the state

    @param dt the time passed between frames
     */
    @Override
    public void update(float dt) {
        if (Gdx.input.justTouched()) {
            SoundEffect startGameSound = new SoundEffect(ResourceLoader.loadPauseSound());
            startGameSound.playSound();
            MenuState.getMenuMusic().stopSound();
            gsm.set(new PlayState(gsm));
        }
    }
    /*
    renders the current state

    @param batch the batch to be used for drawing
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(spells, 255 - spells.getWidth() / 2, 0);
        batch.end();

    }
    /*
    frees the memory allocated by the object
     */
    @Override
    public void dispose() {
        spells.dispose();
    }
}