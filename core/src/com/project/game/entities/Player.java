package com.project.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.project.game.Animation;
import com.project.game.Game;
import com.project.game.ResourceLoader;
import com.project.game.states.PlayState;

public class Player extends Entity{
    public static final int WIDTH = 18;
    public static final int HEIGHT = 18;
    Vector2 velocity;
    Animation walk;
    Animation idle;
    Animation attack;
    static final int SPEED = 100;
    boolean attacking;
    Vector2 center;
    public Player(){
        super(125 /2, 125/2, WIDTH, HEIGHT);
        center = new Vector2();
        attacking = false;

        walk = new Animation(ResourceLoader.loadWizardWalk(), 0.06f);
        idle = new Animation(ResourceLoader.loadWizardIdle(),.1f);
        attack = new Animation(ResourceLoader.loadWizardAttack(),.1f);

        velocity = new Vector2(0,0);


    }

    @Override
    public Sprite getSprite(){
        if(attacking)
            return attack.getSprite();
        else if(velocity.x == 0 && velocity.y == 0)
            return idle.getSprite();
        else
            return walk.getSprite();
    }
    public void moveLeft(boolean moving){
        if(moving) {
            velocity.x -= SPEED;
            walk.setLeft();
            idle.setLeft();
            attack.setLeft();
        }
        else
            velocity.x += SPEED;
    }
    public void moveRight(boolean moving){
        if(moving) {
            velocity.x += SPEED;
            walk.setRight();
            idle.setRight();
            attack.setRight();
        }
        else
            velocity.x -= SPEED;
    }
    public void moveUp(boolean moving){
        if(moving)
            velocity.y += SPEED;
        else
            velocity.y -= SPEED;
    }
    public void moveDown(boolean moving){
        if(moving)
            velocity.y -= SPEED;
        else
            velocity.y += SPEED;
    }

    @Override
    public void update(float dt){
        if(attack.getCurrentFrame() == 6 && attacking)
        attacking = false;

        hitbox.setPosition(hitbox.getX() + velocity.x*dt,
                           hitbox.getY() + velocity.y*dt);

        walk.update(dt);
        idle.update(dt);
        attack.update(dt);
    }

    public void shoot(int x, int y){
        center = hitbox.getCenter(center);
        double angle = Math.atan2((y-center.y), (x-center.x));
        attacking = true;
        FireBall fireBall = new FireBall(angle, new Vector2(center.x, center.y));
        PlayState.addFireBall(fireBall);
        attack.resetFrames();

    }

    @Override
    public void dispose(){
        walk.dispose();
        attack.dispose();
        idle.dispose();
    }

}
