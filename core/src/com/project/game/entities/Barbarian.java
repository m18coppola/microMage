package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.project.game.Animation;
import com.project.game.ResourceLoader;
import com.project.game.states.PlayState;

public class Barbarian extends Enemy {
    public static final int WIDTH = 18;
    public static final int HEIGHT = 18;
    public static final float attackRange = 60;
    Vector2 velocity;
    Animation walk;
    Animation idle;
    Animation attack;
    static final int SPEED = 100;
    boolean attacking;
    Vector2 center;
    Vector2 target;
    boolean movement = false;
    public float duration = 0.5f;
    public float elapsed = 0.0f;
    public int health = 90;


    public Barbarian(int x, int y) {

        super(x, y, WIDTH, HEIGHT);
        center = new Vector2();
        attacking = false;
        idle = new Animation(ResourceLoader.loadBarbarianIdle(), .1f);
        walk = new Animation(ResourceLoader.loadBarbarianWalk(), 0.06f);
        attack = new Animation(ResourceLoader.loadBarbarianAttack(), 0.1f);
        velocity = new Vector2(0, 0);
        target = new Vector2();
    }


    public Sprite getSprite() {
        if (attacking)
            return attack.getSprite();
        else if (velocity.x == 0 && velocity.y == 0)
            return idle.getSprite();
        else
            return walk.getSprite();
    }

    public void moveLeft() {
        if (movement) {
            velocity.x -= SPEED;
            walk.setLeft();
            idle.setLeft();
            attack.setLeft();
        }
    }


    public void moveRight() {
        if (movement) {
            velocity.x += SPEED;
            walk.setRight();
            idle.setRight();
            attack.setRight();
        }
    }


    public void moveUp() {
        if (movement) {
            velocity.y += SPEED;
        }

    }

    public void moveDown() {
        if (movement) {
            velocity.y -= SPEED;
        }
    }

    public void damage(int damage) {
        health -= damage;
    }


    public void attack(float x, float y) {
        if (attack.getCurrentFrame() == 7 && attacking) {
            attacking = false;
        }

        if (attacking) {
            hitbox.getCenter(center);
            double angle = Math.atan2((y - center.y), (x - center.x));
            Axe axe = new Axe(angle, new Vector2(center.x, center.y));
            PlayState.addEnemyProjectile(axe);

        }
    }




    @Override
    public void update(float dt) {

        hitbox.getCenter(center);
        PlayState.player.hitbox.getCenter(target);
        this.idle.update(dt);
        this.attack.update(dt);
        if (center.dst(target) < attackRange) {
            if (center.x < target.x) {
                attack.setRight();
            } else {
                attack.setLeft();
            }

            attacking = true;
            if (elapsed < duration) {
                elapsed += dt;
            } else {
                elapsed = 0;
                attack(PlayState.player.hitbox.getX(), PlayState.player.hitbox.getY());
            }
        } else {
            attacking = false;
        }
        for (Spells s : PlayState.projectiles) {

            if (this.collidesWith(s)) {
                if (s instanceof LightningBolt) {
                    this.damage(90);
                }
                if (s instanceof FireBall) {
                    this.damage(45);
                }
                if (s instanceof SnowBall) {
                    this.damage(30);
                }


            }
            if (this.health <= 0) {
                PlayState.killedEnemies.add(this);
                Player.setMana(Player.mana + 1);
            }
        }
    }




    @Override
    public void dispose() {
        walk.dispose();
        attack.dispose();
        idle.dispose();
    }

}
