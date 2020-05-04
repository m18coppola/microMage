package com.project.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.project.game.entities.tiles.Wall;
import com.project.game.states.PlayState;

import java.util.ArrayList;

public class RayCaster {
    ArrayList<Wall> walls;
    Ray[] rays;
    public ArrayList<Vector2> verts;

    public RayCaster(ArrayList<Wall> walls) {
        this.walls = walls;
        rays = new Ray[720];

    }

    public void update(Vector2 pos) {
        for (int i = 0; i < rays.length; i++) {
            rays[i] = new Ray((float)i/2f, walls);
            rays[i].setPosition(new Vector2(pos));
            rays[i].calc();
        }

        verts = new ArrayList<Vector2>();

        for (int i = 0; i < rays.length; i++) {
            try {
                //rays[i].join();
                verts.add(rays[i].getPosition());
            } catch (Exception e) {
            };
        }
    }

    public Texture getShadow(Vector2 posU) {
        OrthographicCamera cam = new OrthographicCamera();
        cam.setToOrtho(false, 500, 500);
        Vector3 pos = cam.unproject(new Vector3(posU, 0));
        Pixmap overlay = new Pixmap(500, 500, Pixmap.Format.RGBA8888);
        overlay.setColor(0, 0, 0, 1);
        overlay.fillRectangle(0, 0, 500, 500);
        overlay.setBlending(Pixmap.Blending.None);
        overlay.setColor(0, 0, 0, 0);

        for (int i = 0; i < verts.size() - 1; i++) {
            Vector3 v1 = cam.unproject(new Vector3(verts.get(i).x,verts.get(i).y,0f));
            Vector3 v2 = cam.unproject(new Vector3(verts.get(i + 1).x,verts.get(i + 1).y,0f));
            overlay.fillTriangle((int)pos.x,(int)pos.y,(int)v1.x,(int)v1.y,(int)v2.x,(int)v2.y);
        }
        overlay.setBlending(Pixmap.Blending.SourceOver);
        Texture t = new Texture(overlay);
        overlay.dispose();
        return t;
    }

    class Ray extends Thread {
        static final float MARCH_SIZE = 1.25f;
        private float angle;
        ArrayList<Wall> walls;
        Vector2 position;
        boolean found = false;

        public Ray(float angle, ArrayList<Wall> walls) {
            this.angle = angle;
            this.walls = walls;
        }

        public void setPosition(Vector2 position) {
            this.position = position;
        }

        public Vector2 getPosition() {
            return position;
        }


        public void calc() {
            int i = 0;
            while (!found && i < 45) {
                //check if we collided
                for (Wall w : walls) {
                    if (w.hitbox.contains(position)) {
                        found = true;
                        break;
                    }
                }
                //march if we haven't
                position.add((float) Math.cos(angle) * MARCH_SIZE, (float) Math.sin(angle) * MARCH_SIZE);

                i++;

            }
        }
    }
}
