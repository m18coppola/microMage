package com.project.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.Controller;
import com.project.game.Game;
import com.project.game.entities.Player;

public class PlayState extends State{
    GameStateManager gsm;
    Player player;
    public PlayState(GameStateManager gsm){
        super(gsm);
        this.player = new Player();
        cam.setToOrtho(false, Game.WIDTH/4 , Game.HEIGHT/4);
    }

    @Override
    public void update(float dt) {
        handleInput();
        player.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(player.getSprite(), player.getPosition().x, player.getPosition().y);
        float dt = Gdx.graphics.getDeltaTime();
        player.update(dt);
        sb.end();
    }

    @Override
    public void handleInput() {
        Gdx.input.setInputProcessor(new Controller(player));

    }

    public void dispose() {
        player.dispose();
    }
}
