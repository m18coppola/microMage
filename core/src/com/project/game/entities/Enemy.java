package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Enemy extends Entity {
    Vector2 position;
    protected Rectangle hitbox;

    public Enemy(float x, float y, int width, int height) {
        super(x, y, width, height);
        hitbox = new Rectangle(x, y, width, height);
        position = hitbox.getPosition(position);
    }


    public abstract Sprite getSprite();

    public abstract void moveRight();

    public abstract void moveLeft();

    public abstract void moveUp();

    public abstract void moveDown();

    public abstract void attack(int x, int y);


    @Override
    public void update(float dt) {

    }



    @Override
    public void dispose() {

    }

}
