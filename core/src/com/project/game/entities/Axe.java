package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.project.game.ResourceLoader;
import com.project.game.entities.tiles.Tile;
import com.project.game.entities.tiles.Wall;
import com.project.game.states.PlayState;

public class Axe extends EnemyProjectiles {
    Vector2 velocity;
    Sprite sprite;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 9;
    public static final int SPEED = 100;
    public static final float ROTATION_SPEED = 20;
/*
Represents the weapon, axe to be used by the barbarian

 */
    public Axe(double angle, Vector2 position) {
        super(position.x - WIDTH / 2, position.y - HEIGHT / 2, WIDTH, HEIGHT);
        sprite = ResourceLoader.loadAxe();
        velocity = new Vector2((float) (Math.cos(angle) * SPEED), (float) (Math.sin(angle) * SPEED));
    }

    // return the sprite being used for the axe
    public Sprite getSprite() {
        return sprite;
    }

    //updates a single axe object every delta time
    public void update(float dt) {
        //adds rota
        sprite.rotate(ROTATION_SPEED);

        hitbox.setPosition(hitbox.getX() + velocity.x * dt,
                hitbox.getY() + velocity.y * dt);

        // Looks for collision of the axe with a wall
        for (Tile t : PlayState.tileMap.tiles) {
            if (t instanceof Wall) {
                if (this.collidesWith(t)) {
                    //adds the the colliding axe into an array list of colliding enemy projectile
                    PlayState.removedProjectiles.add(this);
                }
            }
        }

    }

    //discards outdated objects that are taking up memory
    public void dispose() {
        sprite.getTexture().dispose();
    }

}
