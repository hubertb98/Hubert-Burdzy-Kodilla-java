package com.kodilla.rps;

import java.util.Optional;

public class RPSGameRule implements GameRule {
    private static final int RULE[][] = {
            {0, -1, 1},
            {1, 0, -1},
            {-1, 1, 0}
    };

    @Override
    public Optional<Player> whoWin(Player p1, Player p2, int p1Move, int p2Move) {
        int result = RULE[p1Move][p2Move];
        switch (result) {
            case 1:
                return Optional.of(p1);
            case -1:
                return Optional.of(p2);
            default:
                return Optional.empty();
        }
    }
}
