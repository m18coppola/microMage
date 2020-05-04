package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.ResourceLoader;
import com.project.game.SoundEffect;

public class MenuState extends State {
    Texture playBtn;
    Texture background;
    Texture title;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("UI/background.bmp");
        playBtn = new Texture("UI/playbtn.png");
        title = new Texture("UI/microMage.png");
    }

    @Override
    public void update(float dt) {
        if (Gdx.input.justTouched()) {
            SoundEffect startGameSound = new SoundEffect(ResourceLoader.loadPauseSound());
            startGameSound.playSound();
            gsm.set(new InstructionState(gsm));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(background, 0, 0, 500, 500);
        batch.draw(playBtn, 250 - playBtn.getWidth() / 2, 275);
        batch.draw(title, 250 - title.getWidth() / 2, 350);
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        title.dispose();
        playBtn.dispose();
    }
}
