package com.project.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ResourceLoader {
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


    public static Sprite loadSnowBall() { return new Sprite(new Texture("items/snowball.png")); }

    public static Sprite loadLightningBolt() { return new Sprite(new Texture("items/lightningbolt.png")); }

    public static Sprite loadFilledHeart(){ return new Sprite(new TextureRegion(new Texture("UI/heart-sprite-png.png"), 11, 29, 280,256 ));}

    public static Sprite loadEmptyHeart(){ return new Sprite(new TextureRegion(new Texture("UI/heart-sprite-png.png"), 608, 34, 280,256 ));}

    public static Sprite loadFilledManaHeart(){ return new Sprite(new TextureRegion(new Texture("UI/manaHeart.png"),11,29,280,256));}

    public static Sprite loadEmptyManaHeart(){ return new Sprite(new TextureRegion(new Texture("UI/manaHeart.png"),608,34,280,256));}
}
