package com.project.game.States;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.Game;

public class MenuState extends State{

    Texture background;
    Texture playBtn;
    Texture title;

    public MenuState(GameStateManager gsm){
        super(gsm);
        background = new Texture("UI/background.bmp");
        playBtn = new Texture("UI/playBtn.png");
        title = new Texture("UI/microMage.png");
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
            sb.begin();
            sb.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
            sb.draw(playBtn, (Game.WIDTH / 2) - (playBtn.getWidth() / 2), Game.HEIGHT / 2 + 50);
            sb.draw(title, (Game.WIDTH / 2) - (title.getWidth() / 2), Game.HEIGHT / 2 + 150);
            sb.end();


    }

    public void dispose() {
        background.dispose();
        playBtn.dispose();
        title.dispose();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }
}
