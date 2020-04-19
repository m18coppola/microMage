package com.project.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.project.game.Game;

public class Player {
    Texture texture;
    Vector3 position;
    Vector3 velocity;
    public Player(){
        texture = new Texture("characters/wizard/wizard_idle_01.png");
        position = new Vector3(125 / 2,125 / 2,0);
        velocity = new Vector3(0,0,0);

    }

    public Texture getTexture(){
        return texture;
    }
    public Vector3 getPosition(){
        return position;
    }
    public void moveLeft(boolean moving){
        if(moving)
            velocity.x -= 1;
        else
            velocity.x += 1;
    }
    public void moveRight(boolean moving){
        if(moving)
            velocity.x += 1;
        else
            velocity.x -= 1;
    }
    public void moveUp(boolean moving){
        if(moving)
            velocity.y += 1;
        else
            velocity.y -= 1;
    }
    public void moveDown(boolean moving){
        if(moving)
            velocity.y -= 1;
        else
            velocity.y += 1;
    }

    public void update(){
        position.x = position.x + velocity.x;
        position.y = position.y + velocity.y;

    }

    public void shoot(int x, int y){
        double angle = Math.atan2((y-position.y), (x-position.x));

        FireBall fireBall = new FireBall(angle, new Vector3(position.x , position.y, 0));
        Game.addFireBall(fireBall);
        fireBall.start();

    }

    public void dispose(){
        texture.dispose();
    }

}
