package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.ResourceLoader;
import com.project.game.SoundEffect;
import com.project.game.entities.Player;
/*
main menu state
 */
public class MenuState extends State {
    Texture playBtn;
    Texture background;
    Texture title;
    public static SoundEffect menuMusic = new SoundEffect(ResourceLoader.loadMenuMusic());

    /*
    constructs state

    @param gsm the game state manager
     */
    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("UI/background.bmp");
        playBtn = new Texture("UI/playbtn.png");
        title = new Texture("UI/microMage.png");
        menuMusic.playSound();
        Player.enemiesKilled = 0;
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
            gsm.set(new InstructionState(gsm));
        }
    }
    /*
    renders the current state

    @param batch the batch to be used for drawing
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(background, 0, 0, 500, 500);
        batch.draw(playBtn, 250 - playBtn.getWidth() / 2, 275);
        batch.draw(title, 250 - title.getWidth() / 2, 350);
        batch.end();
    }
    /*
    frees the memory allocated by the object
     */
    @Override
    public void dispose() {
        background.dispose();
        title.dispose();
        playBtn.dispose();
    }
    /*
    returns the menu music

    @return the menu music
     */
    public static SoundEffect getMenuMusic() { return menuMusic; }

    }
