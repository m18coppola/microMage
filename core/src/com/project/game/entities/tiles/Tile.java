package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.entities.Entity;

public abstract class Tile extends Entity {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    Sprite sprite;

    public Tile(float x, float y, Sprite sprite) {
        super(x, y, WIDTH, HEIGHT);
        this.sprite = sprite;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void dispose(){
        sprite.getTexture().dispose();
    }
}
