package com.project.game.entities.tiles;

import com.badlogic.gdx.math.Vector2;
import com.project.game.entities.Barbarian;
import com.project.game.entities.Enemy;
import com.project.game.entities.Troll;
import com.project.game.states.PlayState;

import java.util.ArrayList;
import java.util.Random;

public class TileMap {

    public enum GridSpace {empty, wall, floor}

    public GridSpace[][] grid;
    public Tile[] tiles;
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    ArrayList<Walker> walkers = new ArrayList<Walker>();
    final float CHANCE_WALKER_CHANGE_DIR = 0.5f;
    final float CHANCE_WALKER_SPAWN = 0.05f;
    final float CHANCE_WALKER_DESTROY = 0.05f;
    final float ENEMY_SPAWN_CHANCE = 0.05f;
    private static Random rand = new Random();
    public Vector2 playerSpawn = new Vector2();
    public static ArrayList<Enemy> enemies;
    private boolean alt;
    public Vector2 goalPos;
    private boolean playerPlaced;

    final int MAX_WALKERS = 10;
    final float PERCENT_TO_FILL = 0.25f;

    class Walker {
        Vector2 direction;
        Vector2 position;

        public Walker() {
            direction = new Vector2();
            position = new Vector2();
        }
    }

    public TileMap(boolean alt) {
        this.alt = alt;
        setup();
        CreateFloors();
        CreateWalls();
        GenerateTiles();
        PlaceGoal();
    }

    private void PlaceGoal() {

         //prevent collision locks
        int i = tiles.length - 1;
        while(!(tiles[i] instanceof Floor)){
            i--;
        }
        Tile t = tiles[i];
        tiles[i] = new Goal(t.getPosition().x,t.getPosition().y,alt);
    }

    private void GenerateTiles() {
        tiles = new Tile[WIDTH * HEIGHT];
        int i = 0;
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Tile newTile = null;
                switch (grid[x][y]) {
                    case wall:
                        newTile = new Wall(x * 16, y * 16, alt);
                        break;
                    case floor:
                        newTile = new Floor(x * 16, y * 16, alt);
                        if(!playerPlaced){
                            tiles[i] = newTile;
                            tiles[i].hitbox.getPosition(playerSpawn);
                            playerSpawn.add(0,2);
                            playerPlaced = true;
                        }
                        if(rand.nextFloat() < ENEMY_SPAWN_CHANCE && playerSpawn.dst(x * 16, y * 16) > 60){
                            enemies.add((alt)?new Barbarian(x * 16, y * 16):new Troll(x * 16, y * 16));
                        }
                        break;
                }
                tiles[i] = newTile;
                i++;
            }
        }
    }

    private void setup() {

        grid = new GridSpace[WIDTH][HEIGHT];
        enemies  = new ArrayList<Enemy>();
        playerPlaced = false;

        //initialize grid
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                grid[x][y] = GridSpace.empty;
            }
        }
        //setup walker
        Walker newWalker = new Walker();
        newWalker.direction = randomDirection();
        Vector2 spawnPos = new Vector2((int) (WIDTH / 2), (int) (HEIGHT / 2));
        newWalker.position.set(spawnPos);
        walkers.add(newWalker);
    }

    private Vector2 randomDirection() {
        int dir = rand.nextInt(4);
        Vector2 newDir;
        switch (dir) {
            case 0:
                newDir = new Vector2(0, 1);
                break;
            case 1:
                newDir = new Vector2(0, -1);
                break;
            case 2:
                newDir = new Vector2(1, 0);
                break;
            default:
                newDir = new Vector2(-1, 0);
                break;
        }
        return newDir;
    }

    private void CreateFloors() {
        int iterations = 0;
        do {
            //place floor
            for (Walker w : walkers) {
                grid[(int) w.position.x][(int) w.position.y] = GridSpace.floor;
            }
            //check for walker destruction
            int numberChecks = walkers.size();
            for (int i = 0; i < numberChecks; i++) {
                if (rand.nextFloat() < CHANCE_WALKER_DESTROY && walkers.size() > 1) {
                    walkers.remove(i);
                    i = numberChecks; //destroy one walker per iteration
                }
            }
            //check for redirection of each walker
            for (int i = 0; i < walkers.size(); i++) {
                if (rand.nextFloat() < CHANCE_WALKER_CHANGE_DIR) {
                    Walker w = walkers.get(i);
                    w.direction = randomDirection();
                }
            }
            //check for walker spawn
            numberChecks = walkers.size();
            for (int i = 0; i < numberChecks; i++) {
                if (rand.nextFloat() < CHANCE_WALKER_SPAWN && walkers.size() < MAX_WALKERS) {
                    //create walker
                    Walker newWalker = new Walker();
                    newWalker.direction = randomDirection();
                    newWalker.position = new Vector2(walkers.get(i).position);
                    walkers.add(newWalker);

                }
            }
            //move walkers
            for (int i = 0; i < walkers.size(); i++) {
                Walker w = walkers.get(i);
                Vector2 newPos = new Vector2(w.position);
                newPos.add(w.direction);
                //only move if it is in bounds
                if (newPos.x < WIDTH - 2 && newPos.x > 0 &&
                        newPos.y > 0 && newPos.y < HEIGHT - 2) { //leave extra space for wall
                    w.position = newPos;
                }
            }
            if ((float) numberOfFloors() / (float) (WIDTH * HEIGHT) > PERCENT_TO_FILL) {
                iterations = 100000;
            }
            iterations++;
        } while (iterations < 100000);
    }

    private int numberOfFloors() {
        int count = 0;
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (grid[x][y] == GridSpace.floor) {
                    count++;
                }
            }
        }
        return count;
    }

    private void CreateWalls() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (grid[x][y] == GridSpace.floor) {
                    if (grid[x][y + 1] == GridSpace.empty) {
                        grid[x][y + 1] = GridSpace.wall;
                    }
                    if (grid[x][y - 1] == GridSpace.empty) {
                        grid[x][y - 1] = GridSpace.wall;
                    }
                    if (grid[x + 1][y] == GridSpace.empty) {
                        grid[x + 1][y] = GridSpace.wall;
                    }
                    if (grid[x - 1][y] == GridSpace.empty) {
                        grid[x - 1][y] = GridSpace.wall;
                    }
                    if (grid[x - 1][y - 1] == GridSpace.empty) {
                        grid[x - 1][y - 1] = GridSpace.wall;
                    }
                    if (grid[x - 1][y + 1] == GridSpace.empty) {
                        grid[x - 1][y + 1] = GridSpace.wall;
                    }
                    if (grid[x + 1][y - 1] == GridSpace.empty) {
                        grid[x + 1][y - 1] = GridSpace.wall;
                    }
                    if (grid[x + 1][y + 1] == GridSpace.empty) {
                        grid[x + 1][y + 1] = GridSpace.wall;
                    }
                }
            }
        }
    }
}
