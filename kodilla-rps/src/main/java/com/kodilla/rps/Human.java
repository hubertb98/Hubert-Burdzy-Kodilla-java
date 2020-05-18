package com.kodilla.rps;

public class Human implements Players {
    private InputOutput inOut = new InputOutput();
    private int points = 0;

    @Override
    public int getMove() {
        int move = inOut.getIntInput();
        return move;
    }

    @Override
    public int addPoints() {
        points++;
        return points;
    }

    @Override
    public int getPoints() {
        return points;
    }
}
