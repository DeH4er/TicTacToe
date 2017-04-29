package com.deli.tictactoe.utils;

/**
 * Created by denys on 29.04.17.
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void update();
}
