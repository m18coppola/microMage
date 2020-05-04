package com.project.game;

import com.badlogic.gdx.audio.Sound;
import com.project.game.entities.Player;

public class SoundEffect {

    private Sound soundEffect;

    public SoundEffect(Sound sfx)
    {
        soundEffect = sfx;
    }

    public void setSound(Sound soundEffect) {
        this.soundEffect = soundEffect;
    }

    public void playSound()
    {
        soundEffect.play();
    }

    public void dispose()
    {
        soundEffect.dispose();
    }

    public void stopSound() { soundEffect.stop(); }

    public void loop() { soundEffect.loop(); }
}
