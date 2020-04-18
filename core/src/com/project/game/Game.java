package com.project.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.game.entities.Player;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera cam;
	Player player;
	Controller controller;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();
		Gdx.input.setInputProcessor(new Controller(player));
		cam = new OrthographicCamera();
		cam.setToOrtho(false,125 , 125);
	}

	@Override
	public void render () {
		player.update();
		batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(player.getTexture(), player.getPosition().x, player.getPosition().y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		player.dispose();
	}
}
