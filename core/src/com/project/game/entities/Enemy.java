package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Enemy extends Entity {


    public Enemy(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
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
