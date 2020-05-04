package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.ResourceLoader;
import com.project.game.SoundEffect;
/*
gamestate that shows game instruction
 */
public class InstructionState extends State {
    Texture instructions;
    /*
    constructs state

    @param gsm the game state manager
     */
    public InstructionState(GameStateManager gsm) {
        super(gsm);
        instructions = new Texture("UI/instructions.png");
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
            gsm.set(new SpellsState(gsm));
        }
    }
    /*
    renders the current state

    @param batch the batch to be used for drawing
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(instructions, 250 - instructions.getWidth() / 2, 0);
        batch.end();

    }
    /*
    frees the memory allocated by the object
     */
    @Override
    public void dispose() {
        instructions.dispose();
    }
}