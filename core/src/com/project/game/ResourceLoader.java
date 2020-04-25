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
}
