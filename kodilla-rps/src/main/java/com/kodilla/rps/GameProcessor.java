package com.kodilla.rps;


import java.util.Optional;

public class GameProcessor {
    private final Player p1;
    private final Player p2;
    private final GameRule gameRule;
    private int maxPoints;

    public GameProcessor(Player p1, Player p2, GameRule gameRule, int maxPoints) {
        this.p1 = p1;
        this.p2 = p2;
        this.gameRule = gameRule;
        this.maxPoints = maxPoints;
    }

    public void play() {
        do {
            int p1Move = p1.getMove();
            int p2Move = p2.getMove();
            Optional<Player> winner = gameRule.whoWin(p1, p2, p1Move, p2Move);
            winner.ifPresent(Player::addPoints);

        } while (p1.getPoints() < maxPoints || p2.getPoints() < maxPoints);
    }
}
