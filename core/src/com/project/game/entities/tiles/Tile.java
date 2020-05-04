package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.entities.Entity;

/*
the tile abstract class
 */

public abstract class Tile extends Entity {
    private Sprite sprite, altSprite;

    public boolean alt;

    public enum TileType {
        wall, floor
    }

    public static final int DIM = 8;

    /*
    constructs a tile object

    @param x the x pos of the tile
    @param y the y pos of the tile
    @param sprite the sprite to be used
    @param altSprite palette swap sprite
    @param altPalette toggles palette swap
     */

    public Tile(float x, float y, Sprite sprite, Sprite altSprite, boolean altPalette) {
        super(x, y, DIM * 2, DIM * 2);
        this.sprite = sprite;
        this.altSprite = altSprite;
        alt = altPalette;
    }
    /*
    returns the tile's sprite

    @return tile's sprite
     */
    @Override
    public Sprite getSprite() {
        return (alt) ? altSprite : sprite;
    }

    @Override
    public void update(float dt) {

    }
    /*
    free memory stored by object
     */
    @Override
    public void dispose() {
        sprite.getTexture().dispose();
    }
}
