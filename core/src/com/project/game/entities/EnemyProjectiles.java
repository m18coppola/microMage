package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class EnemyProjectiles extends Entity {

    public EnemyProjectiles(float x, float y, int width, int height) {
        super(x, y, width, height);
        hitbox.getPosition(position);
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
