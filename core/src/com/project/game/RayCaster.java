package com.project.game;

import com.badlogic.gdx.math.Vector2;
import com.project.game.entities.tiles.Wall;

public class RayCaster {
    Vector2 position;
    Wall[] walls;
    public RayCaster(float x, float y, Wall[] walls){
        position.set(x, y);
        this.walls = walls;
    }
    class Ray extends Thread{
        static final float MARCH_SIZE = 1f;
        private float angle;
        Wall[] walls;
        Vector2 position;
        boolean found = false;

        public Ray(float x, float y, float angle, Wall[] walls){
            this.angle = angle;
            position.set(x, y);
            this.walls = walls;
        }

        @Override
        public void run(){
            while(!found){
                for(Wall w:walls){
                    if(w.hitbox.contains(position)){
                        found = true;
                        break;
                    }
                }

            }
        }
    }
}
