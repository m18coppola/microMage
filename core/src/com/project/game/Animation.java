package com.project.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Animation {
    Sprite[] frames;
    int frameCount;
    int currentFrame;
    float frameTimeDelta;
    float frameTimeLength;
    boolean isLeft;

    public Animation(Sprite[] frames, float speed) {
        this.frames = frames;
        frameCount = frames.length;
        currentFrame = 0;
        frameTimeDelta = 0;
        frameTimeLength = speed;
    }
    //returns the current frame number of the animation
    public int getCurrentFrame() {
        return currentFrame;
    }

    public void update(float dt) {
        frameTimeDelta += dt;
        if (frameTimeDelta > frameTimeLength) {
            currentFrame++;
            frameTimeDelta = 0;
        }
        if (currentFrame >= frameCount)
            currentFrame = 0;

    }

    //flips the sprite in accordance to movement to left
    public void setLeft() {
        if (!isLeft) {
            isLeft = true;
            for (Sprite s : frames) {
                s.flip(true, false);
            }
        }
    }

    //flips the sprite in accordance to movement to right
    public void setRight() {
        if (isLeft) {
            isLeft = false;
            for (Sprite s : frames) {
                s.flip(true, false);
            }
        }
    }

    //return the sprite of the current frame
    public Sprite getSprite() {
        return frames[currentFrame];
    }

    //resets the frames, to restart the animation
    public void resetFrames() {
        currentFrame = 0;
    }

    //discards outdated objects that are taking up memory
    public void dispose() {
        for (Sprite s : frames) {
            s.getTexture().dispose();
        }
    }

    ;
}
