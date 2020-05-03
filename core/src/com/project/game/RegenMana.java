package com.project.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.project.game.Animation;
import com.project.game.Game;
import com.project.game.ResourceLoader;
import com.project.game.states.PlayState;
import com.project.game.entities.Player;

import java.util.TimerTask;

public class RegenMana extends Thread {
    public static final int DELAY_TIME = 500;
    private Player player;

    public RegenMana(Player p) {
        player = p;
    }

    public void run() {
        while (player.getMana() < 8) {
            try {
                sleep(DELAY_TIME);
            } catch (InterruptedException e) {
            }
            player.setMana(player.getMana() + 1);
        }
    }
}
