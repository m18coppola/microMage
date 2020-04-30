package com.project.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.project.game.entities.Player;
import com.project.game.states.PlayState;
import com.badlogic.gdx.ScreenAdapter;

import static org.graalvm.compiler.nodes.PauseNode.pause;

public class Controller extends InputAdapter {
    Player player;
    public Controller(Player player){

        this.player = player;
    }
    @Override
    public boolean keyDown (int keycode) {
        switch(keycode){
            case Input.Keys.W:
                player.moveUp(true);
                break;
            case Input.Keys.A:
                player.moveLeft(true);
                break;
            case Input.Keys.S:
                player.moveDown(true);
                break;
            case Input.Keys.D:
                player.moveRight(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp (int keycode) {
        switch(keycode){
            case Input.Keys.W:
                player.moveUp(false);
                break;
            case Input.Keys.A:
                player.moveLeft(false);
                break;
            case Input.Keys.S:
                player.moveDown(false);
                break;
            case Input.Keys.D:
                player.moveRight(false);
                break;

        }
        return true;
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        if(button == 0) { // 0 is left click
            Vector3 mousePos = PlayState.cam.unproject(new Vector3(x, y, 0));
            if (mousePos.x >= 115 && mousePos.x <= 125 && mousePos.y >= 115 && mousePos.y <= 125) {
                if (PlayState.isPaused) {
                    PlayState.isPaused = false;
                } else {
                    PlayState.isPaused = true;
                }
            } else if(!PlayState.isPaused){
                player.shoot((int) mousePos.x, (int) mousePos.y);
            }
        }
        return false;
    }
}
