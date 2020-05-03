package com.project.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.project.game.ResourceLoader;

public class LightningBolt extends Spells {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 11;
    public static final int SPEED = 180;
    public static final int MANA = 3;

    public LightningBolt(double angle, Vector2 position) {
        super(angle, position, SPEED, WIDTH, HEIGHT, MANA, ResourceLoader.loadLightningBolt());

    }


    public int getManaUsage() {
        return MANA;
    }

}
