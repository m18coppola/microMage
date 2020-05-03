package com.project.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.project.game.entities.tiles.Tile;

public class ResourceLoader {
    public static Sprite[] loadWizardWalk() {
        return new Sprite[]{
                new Sprite(new Texture("characters/wizard/wizard_run_01.png")),
                new Sprite(new Texture("characters/wizard/wizard_run_02.png")),
                new Sprite(new Texture("characters/wizard/wizard_run_03.png")),
                new Sprite(new Texture("characters/wizard/wizard_run_04.png"))
        };
    }

    public static Sprite[] loadWizardIdle() {
        return new Sprite[]{
                new Sprite(new Texture("characters/wizard/wizard_idle_01.png")),
                new Sprite(new Texture("characters/wizard/wizard_idle_02.png")),
                new Sprite(new Texture("characters/wizard/wizard_idle_03.png")),
                new Sprite(new Texture("characters/wizard/wizard_idle_04.png")),
                new Sprite(new Texture("characters/wizard/wizard_idle_05.png")),
                new Sprite(new Texture("characters/wizard/wizard_idle_06.png")),

        };
    }

    public static Sprite[] loadWizardAttack() {
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


    public static Sprite[] loadBarbarianAttack() {
        return new Sprite[]{
                new Sprite(new Texture("characters/barbarian/barbarian_attack_01.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_attack_02.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_attack_03.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_attack_04.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_attack_05.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_attack_04.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_attack_05.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_attack_06.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_attack_07.png")),
        };
    }

    public static Sprite[] loadBarbarianWalk() {
        return new Sprite[]{
                new Sprite(new Texture("characters/barbarian/barbarian_run_01.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_run_02.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_run_03.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_run_04.png")),

        };
    }

    public static Sprite[] loadBarbarianIdle() {
        return new Sprite[]{
                new Sprite(new Texture("characters/barbarian/barbarian_idle_01.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_idle_02.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_idle_03.png")),
                new Sprite(new Texture("characters/barbarian/barbarian_idle_04.png")),

        };
    }

    public static Sprite[] loadTrollAttack() {
        return new Sprite[]{
                new Sprite(new Texture("characters/troll/troll_attack_01.png")),
                new Sprite(new Texture("characters/troll/troll_attack_02.png")),
                new Sprite(new Texture("characters/troll/troll_attack_03.png")),
                new Sprite(new Texture("characters/troll/troll_attack_04.png")),
                new Sprite(new Texture("characters/troll/troll_attack_05.png")),
                new Sprite(new Texture("characters/troll/troll_attack_04.png")),
                new Sprite(new Texture("characters/troll/troll_attack_05.png")),
                new Sprite(new Texture("characters/troll/troll_attack_06.png")),
                new Sprite(new Texture("characters/troll/troll_attack_07.png")),
                new Sprite(new Texture("characters/troll/troll_attack_08.png")),
        };
    }

    public static Sprite[] loadTrollIdle() {
        return new Sprite[]{
                new Sprite(new Texture("characters/troll/troll_idle_01.png")),
                new Sprite(new Texture("characters/troll/troll_idle_02.png")),
                new Sprite(new Texture("characters/troll/troll_idle_03.png")),
                new Sprite(new Texture("characters/troll/troll_idle_04.png")),

        };
    }

    public static Sprite[] loadTrollWalk() {
        return new Sprite[]{
                new Sprite(new Texture("characters/troll/troll_run_01.png")),
                new Sprite(new Texture("characters/troll/troll_run_02.png")),
                new Sprite(new Texture("characters/troll/troll_run_03.png")),
                new Sprite(new Texture("characters/troll/troll_run_04.png")),

        };
    }


    public static Sprite loadFireBall() {
        return new Sprite(new Texture("items/fireball.png"));
    }


    public static Sprite loadSnowBall() {
        return new Sprite(new Texture("items/snowball.png"));
    }

    public static Sprite loadLightningBolt() {
        return new Sprite(new Texture("items/lightningbolt.png"));
    }

    public static Sprite loadFilledHeart() {
        return new Sprite(new TextureRegion(new Texture("UI/heart-sprite-png.png"), 11, 29, 280, 256));
    }

    public static Sprite loadEmptyHeart() {
        return new Sprite(new TextureRegion(new Texture("UI/heart-sprite-png.png"), 608, 34, 280, 256));
    }

    public static Sprite loadFilledManaHeart() {
        return new Sprite(new TextureRegion(new Texture("UI/manaHeart.png"), 11, 29, 280, 256));
    }

    public static Sprite loadEmptyManaHeart() {
        return new Sprite(new TextureRegion(new Texture("UI/manaHeart.png"), 608, 34, 280, 256));
    }

    static Texture tiles = new Texture("tilesets/topdown.png");
    static Texture altTiles = new Texture("tilesets/topdown_jungle.png");

    public static Sprite loadWall(boolean alt) {
        return new Sprite(new TextureRegion((alt) ? tiles : altTiles, 20, 8, Tile.DIM, Tile.DIM));
    }


    public static Sprite[] loadFloorTiles(boolean alt) {
        int y = 24;
        int x = 0;
        int i = 0;

        Sprite[] sprites = new Sprite[20];
        for (int xCount = 0; xCount < 5; xCount++) {
            for (int yCount = 0; yCount < 4; yCount++) {
                sprites[i] = new Sprite(new TextureRegion((alt) ? tiles : altTiles, xCount * Tile.DIM + x, yCount * Tile.DIM + y, Tile.DIM, Tile.DIM));
                i++;
            }
        }
        return sprites;
    }

    public static Sprite loadGoal(boolean alt) {
        return new Sprite(new TextureRegion((alt) ? tiles : altTiles), 48, 0, Tile.DIM, Tile.DIM);
    }

    public static Sprite loadAxe() {
        return new Sprite(new Texture("items/axe.png"));
    }

    public static Sprite loadArrow() {
        return new Sprite(new Texture("items/arrow.png"));
    }

    public static Sound loadEmptyManaSound() {
        return Gdx.audio.newSound(Gdx.files.internal("sfx/EmptyClip.mp3"));
    }

    public static Sound loadFireballSound() {
        return Gdx.audio.newSound(Gdx.files.internal("sfx/Fireball.mp3"));
    }

    public static Sound loadSnowballSound() {
        return Gdx.audio.newSound(Gdx.files.internal("sfx/Snowball.mp3"));
    }

    public static Sound loadLightningBoltSound() {
        return Gdx.audio.newSound(Gdx.files.internal("sfx/Lightning.mp3"));
    }


    public static Sound loadPauseSound() {return Gdx.audio.newSound(Gdx.files.internal("sfx/PauseSound.mp3"));}

    public static Sound loadGameOver() {return Gdx.audio.newSound(Gdx.files.internal("sfx/GameOver.mp3"));}

    public static Sound loadNewLevelSound() {return Gdx.audio.newSound(Gdx.files.internal("sfx/LevelUpDigital.mp3"));}

    public static Sound loadEnemyHitSound() { return Gdx.audio.newSound(Gdx.files.internal("sfx/enemyhit.wav"));}

    public static Sound loadPlayerHitSound() { return Gdx.audio.newSound(Gdx.files.internal("sfx/playerhit.mp3"));}

    public static Sound loadMenuMusic() { return Gdx.audio.newSound(Gdx.files.internal("sfx/menumusic.wav"));}

    public static Sound loadDungeonMusic() { return Gdx.audio.newSound(Gdx.files.internal("sfx/dungeonmusic.wav"));}

}


