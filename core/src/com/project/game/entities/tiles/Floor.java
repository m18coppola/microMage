package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.ResourceLoader;

import java.util.Random;

public class Floor extends Tile {
    private static Sprite[] floors = ResourceLoader.loadFloorTiles(false);
    private static Sprite[] altFloors = ResourceLoader.loadFloorTiles(true);
    private static Random rand = new Random();

    public Floor(float x, float y, boolean alt) {
        super(x, y, floors[rand.nextInt(floors.length)], altFloors[rand.nextInt(floors.length)], alt);
    }
}
