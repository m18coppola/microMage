package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.project.game.ResourceLoader;

public class Arrow extends EnemyProjectiles {
    Vector2 velocity;
    Sprite sprite;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 9;
    public static final int SPEED = 100;


    public Arrow(double angle, Vector2 position) {
        super(position.x - WIDTH / 2, position.y - HEIGHT / 2, WIDTH, HEIGHT);
        sprite = ResourceLoader.loadArrow();
        sprite.setRotation((float) Math.toDegrees(angle) + 270);
        System.out.println(sprite.getRotation());
        velocity = new Vector2((float) (Math.cos(angle) * SPEED), (float) (Math.sin(angle) * SPEED));
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void update(float dt) {
        hitbox.setPosition(hitbox.getX() + velocity.x * dt,
                hitbox.getY() + velocity.y * dt);


    }

    public void dispose() {
        sprite.getTexture().dispose();
    }

}