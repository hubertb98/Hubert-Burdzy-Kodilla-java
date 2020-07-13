package com.kodilla.rps;

import java.util.Random;

public class Computer implements Player {
    private static final int BOUND = 5;
    private int points = 0;
    private final Random random = new Random();

    @Override
    public int getMove() {
        return random.nextInt(BOUND) + 1;
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
