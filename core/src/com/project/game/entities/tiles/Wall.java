package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Wall extends Tile {
    enum WallType {

    }
    public Wall(float x, float y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void update(float dt) {

    }
}
