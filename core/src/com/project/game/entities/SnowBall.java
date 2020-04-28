package com.project.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.project.game.ResourceLoader;

public class SnowBall extends Spells{
    static Sprite sprite = ResourceLoader.loadSnowBall();

    public static final int WIDTH = 12;
    public static final int HEIGHT = 12;
    public static final int SPEED = 150;
    public static final int DAMAGE = 10;
    public static final int MANA = 1;

    public SnowBall(double angle, Vector2 position){
        super(angle,position,SPEED,WIDTH,HEIGHT,DAMAGE,MANA);
    }

    public Sprite getSprite(){ return sprite; }

    public int getManaUsage() { return MANA; }

}