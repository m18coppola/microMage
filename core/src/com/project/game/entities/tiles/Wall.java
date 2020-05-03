package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.ResourceLoader;

public class Wall extends Tile {
    public Wall(float x, float y, boolean alt) {
        super(x, y,ResourceLoader.loadWall(false), ResourceLoader.loadWall(true), alt);
    }
}
