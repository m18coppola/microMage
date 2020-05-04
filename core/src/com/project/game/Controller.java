package com.project.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.project.game.entities.Player;
import com.project.game.entities.SnowBall;
import com.project.game.states.PlayState;
import com.badlogic.gdx.ScreenAdapter;

import static com.project.game.states.PlayState.currSpell;
/*
Represent the controller class that is dependant upon the input of the user
 */

public class Controller extends InputAdapter {
    Player player;

    public Controller(Player player) {

        this.player = player;
    }

    //detects the input of the user from keyboard and triggers activity accordingly.
    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            //move up
            case Input.Keys.W:
                player.move(Player.Direction.N, true);
                break;
            //move left
            case Input.Keys.A:
                player.move(Player.Direction.W, true);
                break;
            //move right
            case Input.Keys.S:
                player.move(Player.Direction.S, true);
                break;
            //move down
            case Input.Keys.D:
                player.move(Player.Direction.E, true);
                break;
            case Input.Keys.NUM_1:
                    //SnowBall spell
                    currSpell = 1;
                    break;

            case Input.Keys.NUM_2:
                    //FireBall spell
                    currSpell = 2;
                    break;

            case Input.Keys.NUM_3:
                    //Lightning Spell
                    currSpell = 3;
                    break;

            case Input.Keys.ESCAPE:
                Gdx.app.exit();
                break;
        }
        return true;
    }

    //checks for the release of the key, to halt movement
    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                player.move(Player.Direction.N, false);
                break;
            case Input.Keys.A:
                player.move(Player.Direction.W, false);
                break;
            case Input.Keys.S:
                player.move(Player.Direction.S, false);
                break;
            case Input.Keys.D:
                player.move(Player.Direction.E, false);
                break;
        }
        return true;
    }

    //checks the mouse input
    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        if (button == 0) { // 0 is left click
            //checks the click position of the mouse to attack at that position if valid click
            Vector3 mousePos = PlayState.cam.unproject(new Vector3(x, y, 0));
            if (x >= 468 && x <= 493 && y >= 7 && y <= 34) {
                PlayState.isPaused = !PlayState.isPaused;
                SoundEffect pauseSound = new SoundEffect(ResourceLoader.loadPauseSound());
                pauseSound.playSound();
            } else if(!PlayState.isPaused){
                player.shoot((int) mousePos.x, (int) mousePos.y);
            }
        }
        return false;
    }

}
