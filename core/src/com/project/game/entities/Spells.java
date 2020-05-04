package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.project.game.ResourceLoader;
import com.project.game.entities.tiles.Tile;
import com.project.game.entities.tiles.TileMap;
import com.project.game.entities.tiles.Wall;
import com.project.game.states.PlayState;
/*
Represents the general spell class to be extended by each spell that wizard uses
 */
public abstract class Spells extends Entity {
    Vector2 velocity;
    public Sprite sprite;


    public Spells(double angle, Vector2 position, int SPEED, int WIDTH, int HEIGHT, int MANA, Sprite sprite) {
        super(position.x - WIDTH / 2, position.y - HEIGHT / 2, WIDTH, HEIGHT);
        this.sprite = sprite;
        velocity = new Vector2((float) (Math.cos(angle) * SPEED), (float) (Math.sin(angle) * SPEED));
    }

    //updates a spell object every delta time
    public void update(float dt) {
        hitbox.setPosition(hitbox.getX() + velocity.x * dt,
                hitbox.getY() + velocity.y * dt);
        //checks of collision of spells with the walls
        for (Tile t : PlayState.tileMap.tiles) {
            if (t instanceof Wall) {
                //adds the colliding spell to an arrayList of used Projectiles
                if (this.collidesWith(t)) {
                    PlayState.usedProjectiles.add(this);
                }
            }
        }
        //checks of collision of spells with the enemies
        for (Enemy e : TileMap.enemies) {
            //adds the colliding spell to an arrayList of used Projectiles
                if (this.collidesWith(e)) {
                    PlayState.usedProjectiles.add(this);

            }
        }
    }

    //returns the sprite of the spell
    public Sprite getSprite() {
        return sprite;
    }

    //discards outdated objects that are taking up memory
    public void dispose() {
        sprite.getTexture().dispose();
    }

    //return the mana usage of each spell
    public abstract int getManaUsage();

}
