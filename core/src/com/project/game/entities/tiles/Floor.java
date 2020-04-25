package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.ResourceLoader;

import java.util.Random;

public class Floor extends Tile {
    private static Sprite[] tiles = ResourceLoader.loadFloorTiles();
    private static Random rand = new Random();

    public Floor(float x, float y) {
        super(x, y, tiles[rand.nextInt(20)]);

    }


    @Override
    public void update(float dt) {

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
