package com.project.game.entities;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.project.game.Animation;
import com.project.game.ResourceLoader;
import com.project.game.SoundEffect;
import com.project.game.entities.tiles.Goal;
import com.project.game.entities.tiles.Tile;
import com.project.game.entities.tiles.TileMap;
import com.project.game.entities.tiles.Wall;
import com.project.game.states.PlayState;

import static com.project.game.states.PlayState.currSpell;
import static com.project.game.states.PlayState.tileMap;

public class Player extends Entity {
    public enum Direction{N,S,E,W}
    boolean left,right,up,down = false;

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    static final int MAX_MANA = 8;
    private static final float MANA_REGEN_SPEED = 1.5f;
    Vector2 velocity;
    static int health;
    static int mana;
    Animation walk;
    Animation idle;
    Animation attack;
    static final int SPEED = 100;
    static boolean attacking;
    Vector2 center;
    float manaRegen;
    static Spells spellType;
    static SoundEffect spellSound;


    Vector2 oldPos;

    public Player(float x, float y) {
        super(x, y, WIDTH, HEIGHT);
        center = new Vector2();
        attacking = false;
        health = 3;
        mana = MAX_MANA;
        spellSound = new SoundEffect(ResourceLoader.loadEmptyManaSound());


        walk = new Animation(ResourceLoader.loadWizardWalk(), 0.06f);
        idle = new Animation(ResourceLoader.loadWizardIdle(), .1f);
        attack = new Animation(ResourceLoader.loadWizardAttack(), .1f);


        oldPos = new Vector2(this.getPosition());

        velocity = new Vector2(0, 0);
        currSpell = 1;

    }

    @Override
    public Sprite getSprite() {
        if (attacking)
            return attack.getSprite();
        else if (velocity.x == 0 && velocity.y == 0)
            return idle.getSprite();
        else
            return walk.getSprite();
    }

    public void move(Direction d, boolean moving) {
        switch (d){
            case N:
                up = moving;
                break;
            case S:
                down = moving;
                break;
            case E:
                right = moving;
                walk.setRight();
                idle.setRight();
                attack.setRight();
                break;
            case W:
                left = moving;
                walk.setLeft();
                idle.setLeft();
                attack.setLeft();
                break;
        }
    }



    @Override
    public void update(float dt) {
        manaRegen += dt;
        if (manaRegen > MANA_REGEN_SPEED) {
            manaRegen = 0;
            if (mana < MAX_MANA) {
                mana++;
            }
        }
        if (attack.getCurrentFrame() == 6 && attacking)
            attacking = false;
        hitbox.getPosition(oldPos);

        //calc velocity
        if(up){
            velocity.y = SPEED;
        }
        if(down){
            velocity.y = -SPEED;
        }
        if(up == down){
            velocity.y = 0;
        }
        if(left){
            velocity.x = -SPEED;
        }
        if(right){
            velocity.x = SPEED;
        }
        if(left == right) {
            velocity.x = 0;
        }

            //check x collision
        hitbox.setX(hitbox.getX() + velocity.x * dt);
        for (Tile t : PlayState.tileMap.tiles) {
            if (t instanceof Wall) {
                if (this.collidesWith(t)) {
                    hitbox.setX(oldPos.x);
                }
            }
        }
        //check y collision
        hitbox.setY(hitbox.getY() + velocity.y * dt);
        for (Tile t : PlayState.tileMap.tiles) {
            if (t instanceof Wall) {
                if (this.collidesWith(t)) {
                    hitbox.setY(oldPos.y);
                }
            }
        }
        //check goal collision
        for(Tile t : PlayState.tileMap.tiles){
            if(t instanceof Goal) {
                if (this.collidesWith(t) && TileMap.enemies.isEmpty()) {
                    PlayState.nextLevel();
                }
            }
        }

        //check for projectile collision
        for(int i = 0; i < PlayState.enemyProjectiles.size(); i++){
            EnemyProjectiles ep = PlayState.enemyProjectiles.get(i);
            if(ep.collidesWith(this)){
                this.setHealth(getHealth()-1);
                PlayState.enemyProjectiles.remove(ep);
                i--;
            }
        }


        System.out.println(velocity);


        walk.update(dt);
        idle.update(dt);
        attack.update(dt);
    }

    public void shoot(int x, int y) {
        center = hitbox.getCenter(center);
        double angle = Math.atan2((y - center.y), (x - center.x));
        if (currSpell == 1) {
            spellType = new SnowBall(angle, new Vector2(center.x, center.y));
            spellSound.setSound(ResourceLoader.loadSnowballSound());

        } else if (currSpell == 2) {
            spellType = new FireBall(angle, new Vector2(center.x, center.y));
            spellSound.setSound(ResourceLoader.loadFireballSound());
        } else if (currSpell == 3) {
            spellType = new LightningBolt(angle, new Vector2(center.x, center.y));
            spellSound.setSound(ResourceLoader.loadLightningBoltSound());
        }
        if (mana > 0 && mana >= spellType.getManaUsage()) {
            PlayState.addProjectile(spellType);
            setMana(mana - spellType.getManaUsage());
            attacking = true;
            attack.resetFrames();
        } else {
            attacking = false;
            spellSound.setSound(ResourceLoader.loadEmptyManaSound());
        }
        if(PlayState.gsm.peek() instanceof PlayState) {
            spellSound.playSound();
        }
    }

    public static int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        if (newHealth >= 0 && newHealth <= 3) {
            health = newHealth;
        }
    }

    public static int getMana() {
        return mana;
    }

    public static void setMana(int newMana) {
        if (newMana >= 0 && newMana <= 8) {
            mana = newMana;
        }
    }

    public static Spells getSpellType(){ return spellType;}

    public static Boolean isAttacking(){return attacking;}

    public Vector2 getCenter() {
        return hitbox.getCenter(center);
    }

    @Override
    public void dispose() {
        walk.dispose();
        attack.dispose();
        idle.dispose();
        spellSound.dispose();
    }


}
