package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.project.game.ResourceLoader;

public abstract class Spells extends Entity {
    Vector2 velocity;
    public Sprite sprite;


    public Spells(double angle, Vector2 position, int SPEED, int WIDTH, int HEIGHT, int DAMAGE, int MANA, Sprite sprite) {
        super(position.x - WIDTH / 2, position.y - HEIGHT / 2, WIDTH, HEIGHT);
        this.sprite = sprite;
        velocity = new Vector2((float) (Math.cos(angle) * SPEED), (float) (Math.sin(angle) * SPEED));
    }


    public void update(float dt) {
        hitbox.setPosition(hitbox.getX() + velocity.x * dt,
                hitbox.getY() + velocity.y * dt);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void dispose() {
        sprite.getTexture().dispose();
    }

    public abstract int getManaUsage();

}
