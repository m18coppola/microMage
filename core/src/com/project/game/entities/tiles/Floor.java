package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.ResourceLoader;

import java.util.Random;

public class Floor extends Tile {
        private static Sprite[] floors = ResourceLoader.loadFloorTiles();
        private static Random rand = new Random();

        public Floor(float x, float y) {
                super(x, y, floors[rand.nextInt(floors.length)]);
        }
}
