package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.ResourceLoader;

public class Goal extends Tile {
    public Goal(float x, float y, boolean alt) {
        super(x,y, ResourceLoader.loadGoal(false),ResourceLoader.loadGoal(true),alt);
    }
}
