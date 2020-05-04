package com.project.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.project.game.entities.Player;

/*
game over screen state
 */
public class EndGameState extends State {

    Texture endGame;
    OrthographicCamera UIcam;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    BitmapFont font30;
    GlyphLayout gl;
    /*
    constructs a game over state

    @param the game state manager
     */
    public EndGameState(GameStateManager gsm){
        super(gsm);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        endGame = new Texture("UI/Game-Over.png");
        UIcam = new OrthographicCamera();
        UIcam.setToOrtho(false, 500, 500);
        generator = new FreeTypeFontGenerator(Gdx.files.internal("UI/Boxy-Bold.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 30;
        font30 = generator.generateFont(parameter);
        gl = new GlyphLayout();
        gl.setText(font30, "");
    }

    /*
    updates the object

    @param dt time that has passed between frames
     */
    @Override
    public void update(float dt) {
        if(Gdx.input.justTouched()) {
            PlayState.score = 0;
            gsm.set(new MenuState(gsm));
        }
    }
    /*
    renders the screen

    @param batch the sprite batch to draw in
     */
    @Override
    public void render(SpriteBatch batch) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(UIcam.combined);
        batch.begin();
        batch.draw(endGame, 250 - endGame.getWidth()/2,250);
        gl.setText(font30, "Levels Cleared : " + PlayState.score);
        font30.draw(batch,gl, -1 * gl.width/2 + endGame.getWidth()/2, 240);
        gl.setText(font30, "Enemies Killed: " + Player.enemiesKilled);
        font30.draw(batch,gl, -1 * gl.width/2 + endGame.getWidth()/2, 180);
        batch.end();
    }

    /*
    frees memory allocated by the object
     */
    @Override
    public void dispose() {
        endGame.dispose();
        generator.dispose();
    }
}
