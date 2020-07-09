package com.kodilla.rps;

import java.util.Optional;

public interface GameRule {
    Optional<Player> whoWin(Player p1, Player p2, int p1Move, int p2Move);

}
