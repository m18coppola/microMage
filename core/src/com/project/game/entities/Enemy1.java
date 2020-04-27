package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Enemy1 extends Entity{
    public static final int WIDTH = 18;
    public static final int HEIGHT = 18;
    @Override

    public Enemy1() {
        super(125 /2, 125/2, WIDTH, HEIGHT);
    }
    }

    public Sprite getSprite() {
        return null;
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void dispose() {

    }
}
