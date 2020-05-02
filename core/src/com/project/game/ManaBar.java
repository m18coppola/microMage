package com.project.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.entities.Player;

public class ManaBar extends Thread {

    private Sprite filledManaHeart;
    private Sprite emptyManaHeart;
    private Player player;
    private boolean[] manaArray;
    private int xPos;
    private int yPos;
    public final int MANA_HEART_WIDTH = 180;
    public final int MANA_HEART_HEIGHT = 156;

    public ManaBar(Player p) {
        manaArray = new boolean[]{true, true, true, true, true, true, true, true};
        player = p;
        filledManaHeart = ResourceLoader.loadFilledManaHeart();
        emptyManaHeart = ResourceLoader.loadEmptyManaHeart();
    }

    @Override
    public void run() {
        while (true) {
            int mana = Player.getMana();
            synchronized (manaArray) {
                if (mana == 8) {
                    manaArray[0] = true;
                    manaArray[1] = true;
                    manaArray[2] = true;
                    manaArray[3] = true;
                    manaArray[4] = true;
                    manaArray[5] = true;
                    manaArray[6] = true;
                    manaArray[7] = true;
                } else if (mana == 7) {
                    manaArray[0] = true;
                    manaArray[1] = true;
                    manaArray[2] = true;
                    manaArray[3] = true;
                    manaArray[4] = true;
                    manaArray[5] = true;
                    manaArray[6] = true;
                    manaArray[7] = false;
                } else if (mana == 6) {
                    manaArray[0] = true;
                    manaArray[1] = true;
                    manaArray[2] = true;
                    manaArray[3] = true;
                    manaArray[4] = true;
                    manaArray[5] = true;
                    manaArray[6] = false;
                    manaArray[7] = false;
                } else if (mana == 5) {
                    manaArray[0] = true;
                    manaArray[1] = true;
                    manaArray[2] = true;
                    manaArray[3] = true;
                    manaArray[4] = true;
                    manaArray[5] = false;
                    manaArray[6] = false;
                    manaArray[7] = false;
                } else if (mana == 4) {
                    manaArray[0] = true;
                    manaArray[1] = true;
                    manaArray[2] = true;
                    manaArray[3] = true;
                    manaArray[4] = false;
                    manaArray[5] = false;
                    manaArray[6] = false;
                    manaArray[7] = false;
                } else if (mana == 3) {
                    manaArray[0] = true;
                    manaArray[1] = true;
                    manaArray[2] = true;
                    manaArray[3] = false;
                    manaArray[4] = false;
                    manaArray[5] = false;
                    manaArray[6] = false;
                    manaArray[7] = false;
                } else if (mana == 2) {
                    manaArray[0] = true;
                    manaArray[1] = true;
                    manaArray[2] = false;
                    manaArray[3] = false;
                    manaArray[4] = false;
                    manaArray[5] = false;
                    manaArray[6] = false;
                    manaArray[7] = false;
                } else if (mana == 1) {
                    manaArray[0] = true;
                    manaArray[1] = false;
                    manaArray[2] = false;
                    manaArray[3] = false;
                    manaArray[4] = false;
                    manaArray[5] = false;
                    manaArray[6] = false;
                    manaArray[7] = false;
                } else if (mana == 0) {
                    manaArray[0] = false;
                    manaArray[1] = false;
                    manaArray[2] = false;
                    manaArray[3] = false;
                    manaArray[4] = false;
                    manaArray[5] = false;
                    manaArray[6] = false;
                    manaArray[7] = false;
                }

            }
        }
    }

    public void render(SpriteBatch batch) {
        xPos = 118;
        yPos = 110;
        for (boolean life : manaArray) {
            if (life) {
                batch.draw(filledManaHeart, xPos, yPos, 5, 5);
            } else {
                batch.draw(emptyManaHeart, xPos, yPos, 5, 5);
            }
            yPos -= 6;
        }


    }

    public void dispose() {
        filledManaHeart.getTexture().dispose();
        emptyManaHeart.getTexture().dispose();
    }

}

