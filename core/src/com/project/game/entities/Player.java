package com.project.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.project.game.Animation;
import com.project.game.Game;
import com.project.game.ResourceLoader;
import com.project.game.entities.tiles.Tile;
import com.project.game.entities.tiles.Wall;
import com.project.game.states.PlayState;

public class Player extends Entity{
    public static final int WIDTH = 5;
    public static final int HEIGHT = 5;
    static final int MAX_MANA = 8;
    private static final float MANA_REGEN_SPEED = 1.5f;
    Vector2 velocity;
    static int health;
    static int mana;
    Animation walk;
    Animation idle;
    Animation attack;
    static final int SPEED = 100;
    boolean attacking;
    Vector2 center;
    float manaRegen;
    Vector2 oldPos;

    public Player(float x, float y){
        super(x, y, WIDTH, HEIGHT);
        center = new Vector2();
        attacking = false;
        health = 3;
        mana = MAX_MANA;
        walk = new Animation(ResourceLoader.loadWizardWalk(), 0.06f);
        idle = new Animation(ResourceLoader.loadWizardIdle(),.1f);
        attack = new Animation(ResourceLoader.loadWizardAttack(),.1f);
        oldPos = new Vector2(this.getPosition());
        velocity = new Vector2(0,0);

    }

    @Override
    public Sprite getSprite(){
        if(attacking)
            return attack.getSprite();
        else if(velocity.x == 0 && velocity.y == 0)
            return idle.getSprite();
        else
            return walk.getSprite();
    }
    public void moveLeft(boolean moving){
        if(moving) {
            velocity.x -= SPEED;
            walk.setLeft();
            idle.setLeft();
            attack.setLeft();
        }
        else
            velocity.x += SPEED;
    }
    public void moveRight(boolean moving){
        if(moving) {
            velocity.x += SPEED;
            walk.setRight();
            idle.setRight();
            attack.setRight();
        }
        else
            velocity.x -= SPEED;
    }
    public void moveUp(boolean moving){
        if(moving)
            velocity.y += SPEED;
        else
            velocity.y -= SPEED;
    }
    public void moveDown(boolean moving){
        if(moving)
            velocity.y -= SPEED;
        else
            velocity.y += SPEED;
    }

    @Override
    public void update(float dt){
        manaRegen += dt;
        if(manaRegen > MANA_REGEN_SPEED){
            manaRegen = 0;
            if(mana < MAX_MANA){
                mana++;
            }
        }
        if(attack.getCurrentFrame() == 6 && attacking)
        attacking = false;
        hitbox.getPosition(oldPos);
        hitbox.setPosition(hitbox.getX() + velocity.x*dt,
                           hitbox.getY() + velocity.y*dt);
        for(Tile t: PlayState.tileMap.tiles){
            if(t instanceof Wall){
                if(this.collidesWith(t)){
                    hitbox.setPosition(oldPos);
                    System.out.println("colliding with dt at " + dt);
                }
            }
        }
        walk.update(dt);
        idle.update(dt);
        attack.update(dt);
    }

    public void shoot(int x, int y){
        center = hitbox.getCenter(center);
        double angle = Math.atan2((y-center.y), (x-center.x));
        attacking = true;
        SnowBall spellType = new SnowBall(angle, new Vector2(center.x, center.y));
        if(mana > 0) {
            PlayState.addProjectile(spellType);
        }
        setMana(mana - spellType.getManaUsage());
        System.out.println(mana);
        attack.resetFrames();
    }

    public static int getHealth()
    {
        return health;
    }

    public void setHealth(int newHealth)
    {
        if(newHealth >= 0 && newHealth <= 3) {
            health = newHealth;
        }
    }

    public static int getMana() { return mana; }

    public static void setMana(int newMana)
    {
        if(newMana >= 0 && newMana <= 8) {
            mana = newMana;
        }
    }

    public Vector2 getCenter(){return hitbox.getCenter(center);}

    @Override
    public void dispose(){
        walk.dispose();
        attack.dispose();
        idle.dispose();
    }

}
