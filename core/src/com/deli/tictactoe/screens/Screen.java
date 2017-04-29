package com.deli.tictactoe.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.deli.tictactoe.utils.Observer;

/**
 * Created by denys on 29.04.17.
 */
public abstract class Screen {
    private OrthographicCamera camera;
    private GameScreenManager gameScreenManager;

    public Screen(GameScreenManager gameScreenManager) {
        this.gameScreenManager = gameScreenManager;
        camera =  new OrthographicCamera();
    }

    public GameScreenManager getGameScreenManager() {
        return gameScreenManager;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();
}
