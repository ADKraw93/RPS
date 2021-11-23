package com.rps.rps_game;

import java.util.List;

public interface GameRules {

    int check(int player1Move, int player2Move);
    List<String> getAvailableMoves();
    List<String> getPlaysAllowed();
}
