package com.project.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.project.game.Animation;
import com.project.game.ResourceLoader;
import com.project.game.states.PlayState;

public class Barbarian extends Enemy {
    public static final int WIDTH = 18;
    public static final int HEIGHT = 18;
    Vector2 velocity;
    Animation walk;
    Animation idle;
    Animation attack;
    static final int SPEED = 100;
    boolean attacking;
    Vector2 center;
    boolean movement = false;

    public Barbarian() {

        super(100, 100, WIDTH, HEIGHT);
        center = new Vector2();
        attacking = false;
        idle = new Animation(ResourceLoader.loadBarbarianIdle(), .1f);
        walk = new Animation(ResourceLoader.loadBarbarianWalk(), 0.06f);
        attack = new Animation(ResourceLoader.loadBarbarianAttack(), 0.1f);
        velocity = new Vector2(0,0);
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
        velocity.y -= SPEED;
    }

    public void attack(int x, int y) {
        center = hitbox.getCenter(center);
        double angle = Math.atan2((y - center.y), (x - center.x));
        attacking = true;
        Axe axe = new Axe(angle, new Vector2(center.x, center.y));
        PlayState.addAxe(axe);
        attack.resetFrames();
    }


    @Override
    public void update(float dt) {

    }

    @Override
    public void dispose() {

    }
}
