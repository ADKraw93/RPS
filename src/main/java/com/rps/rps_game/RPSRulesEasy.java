package com.rps.rps_game;


import java.util.List;

public class RPSRulesEasy implements GameRules {

    private static final List<String> availableMoves = List.of(
            "x", "n", "1", "2", "3"
    );

    private static final List<String> playsAllowed = List.of(
            "1", "2", "3"
    );

    private static final int[][] RULES = {
            { 0, -1, 1 },
            { 1, 0, -1 },
            { -1, 1, 0 }
    };

    public int check(int player1Move, int player2Move) {
        return RULES[player1Move][player2Move];
    }

    public final List<String> getAvailableMoves() {
        return availableMoves;
    }

    public final List<String> getPlaysAllowed() {
        return playsAllowed;
    }

}
