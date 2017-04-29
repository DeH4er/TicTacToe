package com.deli.tictactoe.screens;

import java.util.Stack;

/**
 * Created by denys on 29.04.17.
 */
public class GameScreenManager {
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

    public Screen peek() {
        return screens.peek();
    }

    public void set(Screen screen) {
        screens.pop();
        screens.push(screen);
    }

}
