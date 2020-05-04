package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.project.game.ResourceLoader;
import com.project.game.entities.tiles.Tile;
import com.project.game.entities.tiles.Wall;
import com.project.game.states.PlayState;
/*
Represent the weapon; Arrow to be used by the Troll

*/
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
        velocity = new Vector2((float) (Math.cos(angle) * SPEED), (float) (Math.sin(angle) * SPEED));
    }

    // returns the sprite of the arrow being used
    public Sprite getSprite() {
        return sprite;
    }

    // Updates a single arrow object for every delta time
    public void update(float dt) {
        hitbox.setPosition(hitbox.getX() + velocity.x * dt,
                hitbox.getY() + velocity.y * dt);

        // Looks for collision of the arrow with a wall
        for (Tile t : PlayState.tileMap.tiles) {
            if (t instanceof Wall) {
                //adds the the colliding arrow into an array list of colliding enemy projectile
                if (this.collidesWith(t)) {
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
