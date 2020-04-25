package com.project.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.project.game.ResourceLoader;

public class FireBall extends Spells{
    static Sprite sprite = ResourceLoader.loadFireBall();

    public static final int WIDTH = 8;
    public static final int HEIGHT = 9;
    public static final int SPEED = 100;
    public static final int DAMAGE = 20;

    public FireBall(double angle, Vector2 position){
        super(angle,position,SPEED,WIDTH,HEIGHT,DAMAGE);

    }

    public Sprite getSprite(){
        return sprite;
    }

}
