package com.project.game.entities.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project.game.ResourceLoader;

public class Wall extends Tile {
    public enum WallType {
        HORIZONTAL(0),
        HORIZONTAL_L_BROKE(1),
        HORIZONTAL_R_BROKE(2),
        VERTICAL(3),
        VERTICAL_T_END(4),
        VERTICAL_B_END(5),
        VERTICAL_T_BROKE(6),
        VERTICAL_B_BROKE(7),
        CORNER_NW(8),
        CORNER_NE(9),
        CORNER_SW(10),
        CORNER_SE(11);
        int ID;
        WallType(int ID){
            this.ID = ID;
        }
    }
    private static Sprite[] sprites = ResourceLoader.loadWallTiles();
    public Wall(float x, float y, WallType type) {

        super(x, y, sprites[type.ID]);
    }

    @Override
    public void update(float dt) {

    }
}
