package com.deli.tictactoe.controllers;

import com.badlogic.gdx.Gdx;
import com.deli.tictactoe.model.GameLogicModel;
import com.deli.tictactoe.screens.Screen;

/**
 * Created by denys on 29.04.17.
 */
public class Controller {
    private GameLogicModel model;

    public Controller(GameLogicModel model) {
        this.model = model;
    }

    public void move(int x, int y) {
        model.move(model.getShouldMove(), x / 160, 2- y / 160 );
    }
}
