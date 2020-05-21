package com.kodilla.rps;

import java.util.Random;

public class Computer implements Players {
    private int points = 0;
    private final Random random = new Random();

    @Override
    public int getMove() {
        int move = random.nextInt(5)+1;
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
