package com.deli.tictactoe.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deli.tictactoe.model.GameLogicModel;
import com.deli.tictactoe.model.GameState;

/**
 * Created by denys on 29.04.17.
 */
public class ResultScreen extends Screen {
    private Texture player1Win;
    private Texture player2Win;
    private Texture draw;

    public ResultScreen(GameScreenManager gameScreenManager) {
        super(gameScreenManager);
        create();

    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            getGameScreenManager().clear();
            getGameScreenManager().push(new MenuScreen(getGameScreenManager()));
            getGameScreenManager().push(new PlayScreen(getGameScreenManager()));

            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();

        if (GameLogicModel.state == GameState.DRAW) {
            spriteBatch.draw(draw, 0, 0);
        } else if (GameLogicModel.state == GameState.PLAYER_1_WIN) {
            spriteBatch.draw(player1Win, 0, 0);
        } else if (GameLogicModel.state == GameState.PLAYER_2_WIN) {
            spriteBatch.draw(player2Win, 0, 0);
        }

        spriteBatch.end();
    }

    @Override
    public void create() {
        draw = new Texture("draw.png");
        player1Win = new Texture("player1Win.png");
        player2Win = new Texture("player2Win.png");
    }

    @Override
    public void dispose() {
        player1Win.dispose();
        player2Win.dispose();
        draw.dispose();
    }
}
