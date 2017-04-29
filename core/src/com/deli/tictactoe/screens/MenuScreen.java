package com.deli.tictactoe.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by denys on 29.04.17.
 */
public class MenuScreen extends Screen {
    Texture menuTexture;

    public MenuScreen(GameScreenManager gameScreenManager) {
        super(gameScreenManager);
        create();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            getGameScreenManager().push(new PlayScreen(getGameScreenManager()));
//            dispose();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(menuTexture, 0,0, GameScreenManager.WIDTH, GameScreenManager.HEIGHT);
        spriteBatch.end();
    }

    @Override
    public void create() {
        menuTexture = new Texture("menubg.png");
    }

    @Override
    public void dispose() {
        menuTexture.dispose();
    }
}
