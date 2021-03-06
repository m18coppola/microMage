package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/*
The general abstract enemy class to be extended by every enemy
 */
public abstract class Enemy extends Entity {


    public Enemy(float x, float y, int width, int height) {
        super(x, y, width, height);
        hitbox.getPosition(position);
    }


    public abstract Sprite getSprite();


    public abstract void attack(float x, float y);


    @Override
    public abstract void update(float dt);

    public abstract void damage(int damage);


    @Override
    public void dispose() {

    }



}
