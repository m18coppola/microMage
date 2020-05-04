package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.ResourceLoader;

/*
in-game ladder tile
 */
public class Goal extends Tile {
    /*
   constructs goal object

   @param x the x position of the ladder
   @param y the y position of the ladder
   @param alt toggles alternate palette
    */
    public Goal(float x, float y, boolean alt) {
        super(x,y, ResourceLoader.loadGoal(false),ResourceLoader.loadGoal(true),alt);
    }
}
