package com.project.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.entities.FireBall;
import com.project.game.entities.Player;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public static OrthographicCamera cam;
	Player player;
	Controller controller;
	static ArrayList<FireBall> fireBalls;
	
	@Override
	public void create () {
		fireBalls = new ArrayList<FireBall>();
		batch = new SpriteBatch();
		player = new Player();
		Gdx.input.setInputProcessor(new Controller(player));
		cam = new OrthographicCamera();
		cam.setToOrtho(false,125 , 125);
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		player.update(dt);
		batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for(FireBall fireBall: fireBalls){
			batch.draw(fireBall.getTexture(),fireBall.getPosition().x -4, fireBall.getPosition().y -5);
		}
		batch.draw(player.getTexture(), player.getPosition().x, player.getPosition().y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
		for(FireBall fireBall: fireBalls){
			fireBall.dispose();
		}
	}

	public static void addFireBall(FireBall f){
		fireBalls.add(f);

	}
}
