package com.deli.tictactoe.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by denys on 29.04.17.
 */
public class MenuScreen extends Screen {

    public MenuScreen(GameScreenManager gameScreenManager) {
        super(gameScreenManager);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            getGameScreenManager().push(new PlayScreen(getGameScreenManager()));
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void dispose() {

    }
}
