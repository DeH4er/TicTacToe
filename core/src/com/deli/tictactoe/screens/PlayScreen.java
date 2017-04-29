package com.deli.tictactoe.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deli.tictactoe.controllers.Controller;
import com.deli.tictactoe.model.GameLogicModel;
import com.deli.tictactoe.model.GameState;
import com.deli.tictactoe.model.Player;

/**
 * Created by denys on 29.04.17.
 */
public class PlayScreen extends Screen {
    private Texture bg;
    private Texture x;
    private Texture o;
    private Controller controller;
    private GameLogicModel model;
    private Player[][] board;
    private SpriteBatch spriteBatchRef;

    public PlayScreen(GameScreenManager gameScreenManager) {
        super(gameScreenManager);

        create();

        model = new GameLogicModel();
        controller = new Controller(model);
        board = model.getBoard();
        model.addObserver(getGameScreenManager());
    }

    public void create() {
        bg = new Texture("bg.png");
        x = new Texture("x.png");
        o = new Texture("o.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            getGameScreenManager().pop();
        }

        if (Gdx.input.justTouched()) {
            controller.move(Gdx.input.getX(), Gdx.input.getY());
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatchRef = spriteBatch;
        spriteBatch.begin();
        spriteBatch.draw(bg, 0, 0);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Player.PLAYER_1) {
                    spriteBatch.draw(x, i * 160, j * 160);
                } else if (board[i][j] == Player.PLAYER_2) {
                    spriteBatch.draw(o, i * 160, j * 160);
                }
            }
        }
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        x.dispose();
        o.dispose();
    }
}
