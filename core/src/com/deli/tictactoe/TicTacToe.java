package com.deli.tictactoe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deli.tictactoe.model.GameLogicModel;
import com.deli.tictactoe.screens.GameScreenManager;
import com.deli.tictactoe.screens.MenuScreen;

public class TicTacToe extends Game {
	SpriteBatch batch;
	GameScreenManager screenManager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		screenManager = new GameScreenManager();
		screenManager.push(new MenuScreen(screenManager));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(75/(float)255, 191/(float)255, 145/(float)255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		screenManager.update(Gdx.graphics.getDeltaTime());
		screenManager.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
