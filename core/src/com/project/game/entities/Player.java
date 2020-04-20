package com.project.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.project.game.Animation;
import com.project.game.Game;

public class Player {
    Texture texture;
    Vector3 position;
    Vector3 velocity;
    Animation walk;
    Animation idle;
    Animation attack;
    int speed = 100;
    Sprite sprite;
    boolean attacking;
    public Player(){
        attacking = false;
        texture = new Texture("characters/wizard/wizard_idle_01.png");
        walk = new Animation(new Texture[]{
                new Texture("characters/wizard/wizard_run_01.png"),
                new Texture("characters/wizard/wizard_run_02.png"),
                new Texture("characters/wizard/wizard_run_03.png"),
                new Texture("characters/wizard/wizard_run_04.png")
        }, 0.06f);
        idle = new Animation(new Texture[]{
                new Texture("characters/wizard/wizard_idle_01.png"),
                new Texture("characters/wizard/wizard_idle_02.png"),
                new Texture("characters/wizard/wizard_idle_03.png"),
                new Texture("characters/wizard/wizard_idle_04.png"),
                new Texture("characters/wizard/wizard_idle_05.png"),
                new Texture("characters/wizard/wizard_idle_06.png"),

        },.1f);
        attack = new Animation(new Texture[]{
                new Texture("characters/wizard/wizard_attack_01.png"),
                new Texture("characters/wizard/wizard_attack_02.png"),
                new Texture("characters/wizard/wizard_attack_03.png"),
                new Texture("characters/wizard/wizard_attack_04.png"),
                new Texture("characters/wizard/wizard_attack_05.png"),
                new Texture("characters/wizard/wizard_attack_06.png"),
                new Texture("characters/wizard/wizard_attack_07.png"),


        },.1f);

        position = new Vector3(125 / 2,125 / 2,0);
        velocity = new Vector3(0,0,0);


    }

    public Texture getTexture(){
        if(attacking)
            return attack.getTexture();
        else if(velocity.x == 0 && velocity.y == 0)
            return idle.getTexture();
        else
            return walk.getTexture();
    }
    public Vector3 getPosition(){
        return position;
    }
    public void moveLeft(boolean moving){
        if(moving)
            velocity.x -= speed;
        else
            velocity.x += speed;
    }
    public void moveRight(boolean moving){
        if(moving)
            velocity.x += speed;
        else
            velocity.x -= speed;
    }
    public void moveUp(boolean moving){
        if(moving)
            velocity.y += speed;
        else
            velocity.y -= speed;
    }
    public void moveDown(boolean moving){
        if(moving)
            velocity.y -= speed;
        else
            velocity.y += speed;
    }

    public void update(float dt){
        if(attack.getCurrentFrame() == 6 && attacking)
        attacking = false;

        position.x = position.x + velocity.x*dt;
        position.y = position.y + velocity.y*dt;
        walk.update(dt);
        idle.update(dt);
        attack.update(dt);

    }

    public void shoot(int x, int y){
        double angle = Math.atan2((y-position.y - 3), (x-position.x - 5));
        attacking = true;
        FireBall fireBall = new FireBall(angle, new Vector3(position.x + 5, position.y + 3 , 0));
        Game.addFireBall(fireBall);
        fireBall.start();
        attack.resetFrames();

    }

    public void dispose(){
        texture.dispose();
    }

}
