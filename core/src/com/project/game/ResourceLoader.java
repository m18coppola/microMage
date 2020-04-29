package com.project.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.project.game.entities.tiles.Tile;

public class ResourceLoader {
    static Texture tileAssets = new Texture("tilesets/topdown.png");
    public static Sprite[] loadWizardWalk(){
        return new Sprite[]{
                new Sprite(new Texture("characters/wizard/wizard_run_01.png")),
                new Sprite(new Texture("characters/wizard/wizard_run_02.png")),
                new Sprite(new Texture("characters/wizard/wizard_run_03.png")),
                new Sprite(new Texture("characters/wizard/wizard_run_04.png"))
        };
    }
    public static Sprite[] loadWizardIdle(){
        return new Sprite[]{
                new Sprite(new Texture("characters/wizard/wizard_idle_01.png")),
                new Sprite(new Texture("characters/wizard/wizard_idle_02.png")),
                new Sprite(new Texture("characters/wizard/wizard_idle_03.png")),
                new Sprite(new Texture("characters/wizard/wizard_idle_04.png")),
                new Sprite(new Texture("characters/wizard/wizard_idle_05.png")),
                new Sprite(new Texture("characters/wizard/wizard_idle_06.png")),

        };
    }

    public static Sprite[] loadWizardAttack(){
        return new Sprite[]{
                new Sprite(new Texture("characters/wizard/wizard_attack_01.png")),
                new Sprite(new Texture("characters/wizard/wizard_attack_02.png")),
                new Sprite(new Texture("characters/wizard/wizard_attack_03.png")),
                new Sprite(new Texture("characters/wizard/wizard_attack_04.png")),
                new Sprite(new Texture("characters/wizard/wizard_attack_05.png")),
                new Sprite(new Texture("characters/wizard/wizard_attack_06.png")),
                new Sprite(new Texture("characters/wizard/wizard_attack_07.png")),
        };
    }

    public static Sprite loadFireBall() {
        return new Sprite(new Texture("items/fireball.png"));
    }

    public static Sprite[] loadFloorTiles(){
        int y = 24;
        int x = 0;
        int i = 0;

        Sprite[] sprites = new Sprite[20];
        for(int xCount = 0; xCount < 5; xCount++) {
            for(int yCount = 0; yCount < 4; yCount++){
                sprites[i] = new Sprite(new TextureRegion(tileAssets, xCount* Tile.WIDTH + x, yCount * Tile.HEIGHT + y, Tile.WIDTH, Tile.HEIGHT));
                i++;
            }
        }
        return sprites;
    }

    public static Sprite[] loadWallTiles(){
        Sprite[] sprites = new Sprite[12];  //12 wall types
        sprites[0]  = new Sprite(new TextureRegion(tileAssets,8,0, Tile.WIDTH, Tile.HEIGHT)); // HORIZONTAL
        sprites[1]  = new Sprite(new TextureRegion(tileAssets,40,0, Tile.WIDTH, Tile.HEIGHT)); // HORIZONTAL_L_BROKE
        sprites[2]  = new Sprite(new TextureRegion(tileAssets,32,0, Tile.WIDTH, Tile.HEIGHT)); // HORIZONTAL_R_BROKE
        sprites[3]  = new Sprite(new TextureRegion(tileAssets,20,8, Tile.WIDTH, Tile.HEIGHT)); // VERTICAL
        sprites[4]  = new Sprite(new TextureRegion(tileAssets,20,0, Tile.WIDTH, Tile.HEIGHT)); // VERTICAL_T_END
        sprites[5]  = new Sprite(new TextureRegion(tileAssets,20,16, Tile.WIDTH, Tile.HEIGHT)); // VERTICAL_B_END
        sprites[6]  = new Sprite(new TextureRegion(tileAssets,4,9, Tile.WIDTH, Tile.HEIGHT)); // VERTICAL_T_BROKE
        sprites[7]  = new Sprite(new TextureRegion(tileAssets,4,16, Tile.WIDTH, Tile.HEIGHT)); // VERTICAL_B_BROKE
        sprites[8]  = new Sprite(new TextureRegion(tileAssets,32,8, Tile.WIDTH, Tile.HEIGHT)); // CORNER_NW
        sprites[9]  = new Sprite(new TextureRegion(tileAssets,40,8, Tile.WIDTH, Tile.HEIGHT)); // CORNER_NE
        sprites[10] = new Sprite(new TextureRegion(tileAssets,32,16, Tile.WIDTH, Tile.HEIGHT)); // CORNER_SW
        sprites[11] = new Sprite(new TextureRegion(tileAssets,40,16, Tile.WIDTH, Tile.HEIGHT)); // CORNER_SE
        return sprites;
    }
}
