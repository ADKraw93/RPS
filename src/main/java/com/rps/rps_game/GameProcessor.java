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
                   if (player1.getPoints() < numberOfWins && player2.getPoints() < numberOfWins) {
                       printSureToExitMessage();
                       player1Move = player1.gamersMove();
                       if ("T".equals(player1Move)) {
                           player2.setPoints(0);
                           player1.setPoints(0);
                           printNewGameMessage();
                       } else {
                           printGoOnMessage();
                           skipPlayer2 = true;
                       }
                   } else {
                       player1.setPoints(0);
                       player2.setPoints(0);
                       printNewGameMessage();
                   }
               }

               //procedury wyjścia z gry gracza 1
               if("x".equals(player1Move)) {
                   if(player1.getPoints() < numberOfWins && player2.getPoints() < numberOfWins){
                       printSureToExitMessage();
                       player1Move = player1.gamersMove();
                       if("T".equals(player1Move)) {
                           printNiceToMeetMessage(player1.getName());
                           break;
                       } else {
                           printGoOnMessage();
                           skipPlayer1 = true;
                       }
                   } else {
                       printNiceToMeetMessage(player1.getName());
                       break;
                   }
               }
           }

           if(!skipPlayer2){
               do {
                   player2Move = player2.gamersMove();
                   skipPlayer1 = false;
               } while (!checkPlayerMove(player2Move));

               //procedury ponownej rozgrywki gracza 2
               if("n".equals(player2Move)){
                   if(player1.getPoints() < numberOfWins && player2.getPoints() < numberOfWins){
                       printSureToExitMessage();
                       player2Move = player2.gamersMove();
                       if("T".equals(player2Move)){
                           player2.setPoints(0);
                           player1.setPoints(0);
                           printNewGameMessage();
                       } else {
                           printGoOnMessage();
                           skipPlayer1 = true;
                       }
                   } else {
                       player1.setPoints(0);
                       player2.setPoints(0);
                       printNewGameMessage();
                   }
               }

               //procedury wyjścia z gry gracza 2
               if("x".equals(player2Move)) {
                   if(player1.getPoints() < numberOfWins && player2.getPoints() < numberOfWins){
                       printSureToExitMessage();
                       player2Move = player2.gamersMove();
                       if("T".equals(player2Move)) {
                           printNiceToMeetMessage(player2.getName());
                           break;
                       } else {
                           printGoOnMessage();
                           skipPlayer1 = true;
                       }
                   } else {
                       printNiceToMeetMessage(player2.getName());
                       break;
                   }
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

                if(!(player1 instanceof Computer) && !(player2 instanceof Computer)){ //zabezpieczenie jakbym puścił grę dwóch komputerów, żeby pętla się przerwała bo żaden nie kliknie x
                    printDecideWhatToDoMessage();
                } else {
                    break;
                }
            }
        }
    }

    public int playATurn (String player1Move, String player2Move){
        int turnResult;
        turnResult = rules.check(parseInt(player1Move)-1, parseInt(player2Move)-1);
            System.out.println(player1.getName() + " zagrał/a: " + decodeMoves(player1Move) +
                    ", " + player2.getName() + " zagrał: " + decodeMoves(player2Move) +
                    ", " + decodeTurnResult(turnResult));

        return turnResult;
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

    // metody pomocnicze
    private String decodeMoves (String moveCode){
        String decodeResult = "błąd";

        if ("1".equals(moveCode)) decodeResult = "kamień";
        if ("2".equals(moveCode)) decodeResult = "papier";
        if ("3".equals(moveCode)) decodeResult = "nożyce";

        return decodeResult;
    }

    private String decodeTurnResult (int turnResultCode){
        String decodeResult = "błąd";

        if (turnResultCode == -1) decodeResult = "punkt dla " + player2.getName();
        if (turnResultCode == 0 ) decodeResult = "remis, nikt nie otrzymuje punktu";
        if (turnResultCode == 1) decodeResult = "punkt dla " + player1.getName();

        return decodeResult;
    }
}
