package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
/*
The super class that is extended by all the existing objects in the game world.
 */
public abstract class Entity {
    Vector2 position;

    //hitbox
    public Rectangle hitbox;

    public abstract Sprite getSprite();

    public Entity(float x, float y, int width, int height) {
        position = new Vector2();
        hitbox = new Rectangle(x, y, width, height);
        hitbox.getPosition(position);
    }

    public Vector2 getPosition() {
        return hitbox.getPosition(position);
    }

    public abstract void update(float dt);

    public abstract void dispose();

    public boolean collidesWith(Entity other) {
        return hitbox.overlaps(other.hitbox);
    }

    ;
}
