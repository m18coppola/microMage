package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.ResourceLoader;
import com.project.game.SoundEffect;

public class SpellsState extends State {
    Texture spells;

    public SpellsState(GameStateManager gsm) {
        super(gsm);
        spells = new Texture("UI/spells.png");
    }

    @Override
    public void update(float dt) {
        if (Gdx.input.justTouched()) {
            SoundEffect startGameSound = new SoundEffect(ResourceLoader.loadPauseSound());
            startGameSound.playSound();
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(spells, 255 - spells.getWidth() / 2, 0);
        batch.end();

    }

    @Override
    public void dispose() {
        spells.dispose();
    }
}