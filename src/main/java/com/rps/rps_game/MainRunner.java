package com.rps.rps_game;

public class MainRunner {

    public static void main(String[] args) {

        var playerName = Input.nameInput();
        var numberOfWins = Input.numberOfWinsInput();

        var rules = new RPSRulesEasy();
        var player1 = new Computer(rules.getDrawLimit());
        var player2 = new HumanPlayer(playerName);
        //var player2 = new Computer();

        GameProcessor gameProcessor = new GameProcessor(player1, player2, rules, numberOfWins);

        gameProcessor.playAGame();
    }
}
