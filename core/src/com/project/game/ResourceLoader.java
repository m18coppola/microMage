package com.project.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

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

    public static Sprite loadAxe() {
        return new Sprite(new Texture("items/axe.png"));
    }

    public static Sprite loadArrow() {
        return new Sprite(new Texture("items/arrow.png"));
    }


}


