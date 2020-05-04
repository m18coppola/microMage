package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.ResourceLoader;

import java.util.Random;

/*
in-game floor object
 */

public class Floor extends Tile {
    private static Sprite[] floors = ResourceLoader.loadFloorTiles(false);
    private static Sprite[] altFloors = ResourceLoader.loadFloorTiles(true);
    private static Random rand = new Random();

    /*
    constructs floor object

    @param x the x position of the floor
    @param y the y position of the floor
    @param alt toggles alternate palette
     */
    public Floor(float x, float y, boolean alt) {
        super(x, y, floors[rand.nextInt(floors.length)], altFloors[rand.nextInt(floors.length)], alt);
    }
}
