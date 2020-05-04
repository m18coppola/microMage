package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.ResourceLoader;
/*
in-game wall object
 */
public class Wall extends Tile {
    /*
    constructs wall object

    @param x the x position of the wall
    @param y the y position of the wall
    @param alt toggles alternate palette
     */
    public Wall(float x, float y, boolean alt) {
        super(x, y,ResourceLoader.loadWall(false), ResourceLoader.loadWall(true), alt);
    }
}
