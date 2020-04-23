package com.project.game.States;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.Game;

public class MenuState extends State{

    Texture background;
    Texture playBtn;

    public MenuState(GameStateManager gsm){
        super(gsm);
        background = new Texture("");
        playBtn = new Texture("");
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
            sb.begin();
            sb.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
            sb.draw(playBtn, (Game.WIDTH / 2) - (playBtn.getWidth() / 2), Game.HEIGHT / 2);
            sb.end();


    }

    @Override
    public void handleInput() {
        //if(Gdx.input.justTouched()){
            //gsm.set(new PlayState(gsm));
        //}
    }
}
