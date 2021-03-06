package com.project.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.entities.Player;
import com.project.game.states.EndGameState;
import com.project.game.states.GameStateManager;
/*
Represents the health bar, constant inside the game
*/
public class HealthBar extends Thread {
    private Sprite filledHeart;
    private Sprite emptyHeart;
    private Player player;
    private boolean[] livesArray;
    private int xPos;
    private int yPos;
    public final int HEART_WIDTH = 180;
    public final int HEART_HEIGHT = 156;

    public HealthBar(Player p) {
        livesArray = new boolean[]{true, true, true};
        player = p;
        filledHeart = ResourceLoader.loadFilledHeart();
        emptyHeart = ResourceLoader.loadEmptyHeart();
    }

    //updates the health bar, by running a thread
    @Override
    public void run() {
        while (true) {

            int lives = Player.getHealth();
            //synchronizes the health thread
            synchronized (livesArray) {
                if (lives == 3) {
                    livesArray[0] = true;
                    livesArray[1] = true;
                    livesArray[2] = true;
                } else if (lives == 2) {
                    livesArray[0] = true;
                    livesArray[1] = true;
                    livesArray[2] = false;
                } else if (lives == 1) {
                    livesArray[0] = true;
                    livesArray[1] = false;
                    livesArray[2] = false;
                } else if (lives == 0) {
                    livesArray[0] = false;
                    livesArray[1] = false;
                    livesArray[2] = false;
                }
            }
        }

    }


    //renders the health bar, either filled heart or empty heart
    public void render(SpriteBatch batch) {
        xPos = 5;
        yPos = 5;
        for (boolean life : livesArray) {
            if (life) {
                batch.draw(filledHeart, xPos, yPos, 5, 5);
            } else {
                batch.draw(emptyHeart, xPos, yPos, 5, 5);
            }
            xPos += 6;
        }


    }
    //discards outdated texture that takes up memory
    public void dispose() {
        filledHeart.getTexture().dispose();
        emptyHeart.getTexture().dispose();
    }

}
