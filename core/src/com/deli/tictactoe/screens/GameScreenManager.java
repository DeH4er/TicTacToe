package com.deli.tictactoe.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deli.tictactoe.model.GameLogicModel;
import com.deli.tictactoe.utils.Observer;

import java.util.Stack;

/**
 * Created by denys on 29.04.17.
 */
public class GameScreenManager implements Observer {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 480;
    private Stack<Screen> screens;

    public GameScreenManager() {
        screens = new Stack<Screen>();
    }

    public void pop() {
        screens.pop();
    }

    public void push(Screen screen) {
        screens.push(screen);
    }

    public void update(float deltaTime) {
        screens.peek().update(deltaTime);
    }

    public void render(SpriteBatch batch) {
        screens.peek().render(batch);
    }

    @Override
    public void execute() {
        screens.push(new ResultScreen(this));
    }

    public void clear() {
        while (!screens.empty())
            screens.pop().dispose();
    }
}
