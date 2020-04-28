package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Enemy extends Entity {


    public Enemy(float x, float y, int width, int height) {
        super(x, y, width, height);
    }


    public abstract Sprite getSprite();

    public abstract void moveRight();

    public abstract void moveLeft();

    public abstract void moveUp();

    public abstract void moveDown();
    @Override
    public void update(float dt) {

    }



    @Override
    public void dispose() {

    }

}
