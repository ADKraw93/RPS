package com.rps.rps_game;

public class MainRunner {

    public static void main(String[] args) {

        var playerName = Input.nameInput();
        var numberOfWins = Input.numberOfWinsInput();

        var player1 = new Computer();
        var player2 = new HumanPlayer(playerName);
        //var player2 = new Computer();
        var rules = new RPSRulesEasy();

        GameProcessor gameProcessor = new GameProcessor(player1, player2, rules, numberOfWins);

        gameProcessor.playAGame();

    }
}
