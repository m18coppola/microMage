package com.project.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class FireBall extends Thread{
    Vector3 velocity;
    Vector3 position;
    Texture texture;
    public FireBall(double angle, Vector3 position){
        texture = new Texture("items/axe.png");
        velocity = new Vector3((int)(Math.cos(angle)*10), (int)(Math.sin(angle)*10),0);
        this.position = position;
    }
    public Texture getTexture(){
        return texture;
    }
    public Vector3 getPosition(){
        return position;
    }
    @Override
    public void run(){
        while(true){
            try {
                sleep(100);
            }catch (Exception e){}
            position.add(velocity);
        }
    }
    public void dispose(){
        texture.dispose();
    }

}
