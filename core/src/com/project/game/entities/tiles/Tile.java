package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.entities.Entity;

public abstract class Tile extends Entity {
    private Sprite sprite, altSprite;

    public boolean alt;

    public enum TileType {
        wall, floor
    }

    public static final int DIM = 8;

    public Tile(float x, float y, Sprite sprite, Sprite altSprite, boolean altPallette) {
        super(x, y, DIM * 2, DIM * 2);
        this.sprite = sprite;
        this.altSprite = altSprite;
        System.out.println(hitbox);
        alt = altPallette;
    }

    @Override
    public Sprite getSprite() {
        return (alt) ? altSprite : sprite;
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void dispose() {
        sprite.getTexture().dispose();
    }
}
