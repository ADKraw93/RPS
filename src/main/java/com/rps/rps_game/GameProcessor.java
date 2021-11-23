package com.rps.rps_game;

import java.util.List;

import static com.rps.rps_game.Message.*;
import static java.lang.Integer.parseInt;

public class GameProcessor {

    private final Player player1;
    private final Player player2;
    private final GameRules rules;
    private final int numberOfWins;

    public GameProcessor(Player player1, Player player2, GameRules rules, int numberOfWins) {
        this.player1 = player1;
        this.player2 = player2;
        this.rules = rules;
        this.numberOfWins = numberOfWins;
    }

    public void playAGame(){
        
        printFullRulesMessage();
        printChooseMessage();
        var skipPlayer1 = false;
        var skipPlayer2 = false;
        String player1Move = "";
        String player2Move = "";

       while(true){
           //sprawdzamy, czy dany ruch każdego z graczy jest dozwolony
           if(!skipPlayer1){
               do {
                   player1Move = player1.gamersMove();
                   skipPlayer2 = false;
               } while (!checkPlayerMove(player1Move));

               //procedury ponownej rozgrywki gracza 1
               if("n".equals(player1Move)) {
                   skipPlayer2 = verifyNewGame();
               }

               //procedury wyjścia z gry gracza 1
               if("x".equals(player1Move)){
                   skipPlayer2 = verifyExit(player1);
               }

           }

           if(!skipPlayer2){
               do {
                   player2Move = player2.gamersMove();
                   skipPlayer1 = false;
               } while (!checkPlayerMove(player2Move));

               //procedury ponownej rozgrywki gracza 2
               if("n".equals(player2Move)){
                   skipPlayer1 = verifyNewGame();
               }

               //procedury wyjścia z gry gracza 2
               if("x".equals(player2Move)){
                   skipPlayer1 = verifyExit(player2);
               }
           }

           //sprawdzanie wyniku rozgrywki
            if(checkPlaysAllowed(player1Move) && checkPlaysAllowed(player2Move) && player2.getPoints() < numberOfWins && player1.getPoints() < numberOfWins){
                int turnResult = playATurn(player1Move, player2Move);
                if(turnResult == 1) player1.addPoint();
                if(turnResult == -1 ) player2.addPoint();
                printResults(player1, player2);
            }

            //sprawdzamy ogłoszenie wyników
            if((player2.getPoints() >= numberOfWins || player1.getPoints() >= numberOfWins) && checkPlaysAllowed(player1Move) && checkPlaysAllowed(player2Move)){
                if(player2.getPoints() > player1.getPoints()) {
                    printWinMessage(player2.getName());
                } else {
                    printWinMessage(player1.getName());
                }

                //zabezpieczenie jakbym puścił grę dwóch komputerów, żeby pętla się przerwała bo żaden nie kliknie x
                if(!(player1 instanceof Computer) || !(player2 instanceof Computer)){
                    printDecideWhatToDoMessage();
                } else {
                    break;
                }
            }
        }
    }

    private int playATurn (String player1Move, String player2Move){
        int turnResult;
        turnResult = rules.check(parseInt(player1Move)-1, parseInt(player2Move)-1);
            System.out.println(player1.getName() + " zagrał/a: " + rules.decodeMoves(player1Move) +
                    ", " + player2.getName() + " zagrał: " + rules.decodeMoves(player2Move) +
                    ", " + decodeTurnResult(turnResult));

        return turnResult;
    }

    private boolean verifyExit(Player player){
            if(player1.getPoints() < numberOfWins && player2.getPoints() < numberOfWins){
                printSureToExitMessage();
                String playerMove = player.gamersMove();
                if("T".equals(playerMove)) {
                    printNiceToMeetMessage(player.getName());
                    System.exit(0);
                } else {
                    printGoOnMessage();
                    return true;
                }
            } else {
                printNiceToMeetMessage(player2.getName());
                System.exit(0);
            }
        return false;
    }

    private boolean verifyNewGame(){

            if(player1.getPoints() < numberOfWins && player2.getPoints() < numberOfWins){
                printSureToExitMessage();
                String playerMove = player2.gamersMove();
                if("T".equals(playerMove)){
                    player2.setPoints(0);
                    player1.setPoints(0);
                    printNewGameMessage();
                } else {
                    printGoOnMessage();
                    return true;
                }
            } else {
                player1.setPoints(0);
                player2.setPoints(0);
                printNewGameMessage();
            }
        return false;
    }

    private boolean checkPlayerMove(String move) {
        if(!rules.getAvailableMoves().contains(move)) {
            printWrongButtonMessage();
            printFullRulesMessage();
            return false;
        }
        return true;
    }

    private boolean checkPlaysAllowed(String move) {
        if(!rules.getPlaysAllowed().contains(move)) {
            return false;
        }
        return true;
    }

    private String decodeTurnResult (int turnResultCode){
        String decodeResult = "błąd";

        if (turnResultCode == -1) decodeResult = "punkt dla " + player2.getName();
        if (turnResultCode == 0 ) decodeResult = "remis, nikt nie otrzymuje punktu";
        if (turnResultCode == 1) decodeResult = "punkt dla " + player1.getName();

        return decodeResult;
    }
}
