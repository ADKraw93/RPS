package com.rps.rps_game;

public class Message {

    private static final String rulesIntroMessage = "Grę w papier, kamień, nożyce obsługuje się wciskając następujące przyciski:";
    private static final String push_1Message = "klawisz 1 - zagranie \"kamień\"";
    private static final String push_2Message = "klawisz 2 - zagranie \"papier\"";
    private static final String push_3Message = "klawisz 3 - zagranie \"nożyce\"";
    private static final String push_xMessage = "klawisz x - zakończenie gry";
    private static final String push_nMessage = "klawisz n - uruchomienie gry od nowa";
    private static final String chooseMessage = "Zaczynamy! Wybierz zagranie.";
    private static final String fullRulesMessage = rulesIntroMessage + "\n" +
            push_1Message + "\n" +
            push_2Message + "\n" +
            push_3Message + "\n" +
            push_xMessage + "\n" +
            push_nMessage;
    private static final String wrongButtonMessage = "Nieprawidłowy klawisz\n";
    private static final String sureToExitMessage = "Czy na pewno zakończyć grę? T/N";
    private static final String goOnMessage = "Ok, gramy dalej. Wybierz inny klawisz.";
    private static final String newGameMessage = "Rozpoczynamy nową rozgrywkę. Wciśnij odpowiedni klawisz zagrywki.";
    private static final String decideWhatToDoMessage = "Jeśli chcesz grać od nowa wciśnij \"n\", a jeśli chcesz zakończyć grę to wciśnij \"x\"\n";

    //gettery
    public static String getRulesIntroMessage() {
        return rulesIntroMessage;
    }

    public static String getPush_1Message() {
        return push_1Message;
    }

    public static String getPush_2Message() {
        return push_2Message;
    }

    public static String getPush_3Message() {
        return push_3Message;
    }

    public static String getPush_xMessage() {
        return push_xMessage;
    }

    public static String getPush_nMessage() {
        return push_nMessage;
    }

    public static String getChooseMessage() {
        return chooseMessage;
    }

    public static String getFullRulesMessage() {
        return fullRulesMessage;
    }

    public static String getWrongButtonMessage() {
        return wrongButtonMessage;
    }

    public static String getSureToExitMessage() {
        return sureToExitMessage;
    }

    public static String getGoOnMessage() {
        return goOnMessage;
    }

    public static String getNewGameMessage() {
        return newGameMessage;
    }

    public static String getDecideWhatToDoMessage() {
        return decideWhatToDoMessage;
    }

    //printy
    public static void printRulesIntroMessage() {
        System.out.println(rulesIntroMessage);
    }

    public static void printPush_1Message() {
        System.out.println(push_1Message);
    }

    public static void printPush_2Message() {
        System.out.println(push_2Message);
    }

    public static void printPush_3Message() {
        System.out.println(push_3Message);
    }

    public static void printPush_xMessage() {
        System.out.println(push_xMessage);
    }

    public static void printPush_nMessage() {
        System.out.println(push_nMessage);
    }

    public static void printChooseMessage() {
        System.out.println(chooseMessage);
    }

    public static void printFullRulesMessage() {
        System.out.println(fullRulesMessage);
    }

    public static void printWrongButtonMessage() {
        System.out.println(wrongButtonMessage);
    }

    public static void printSureToExitMessage() {
        System.out.println(sureToExitMessage);
    }

    public static void printGoOnMessage() {
        System.out.println(goOnMessage);
    }

    public static void printNewGameMessage() {
        System.out.println(newGameMessage);
    }

    public static void printDecideWhatToDoMessage() {
        System.out.println(decideWhatToDoMessage);
    }

    //personalised messeges
    public static void printNiceToMeetMessage(String name) {
        System.out.println("Miło było z Tobą pograć " + name + ". Do zobaczenia kolejnym razem!");
    }

    public static void printResults(Player player1, Player player2) {
        System.out.println("Aktualne wyniki:\n" +
                player1.getName() + ": " + player1.getPoints() + "\n" +
                player2.getName() + ": " + player2.getPoints() + "\n");
    }

    public static void printWinMessage(String name){
        System.out.println("To koniec rozgrywki. Pojedynek wygrał: " + name);
    }

    public static void printLooseMessage(String name) {
        System.out.println("Niestety " + name + " przegrałeś/aś, ale głowa do góry! Kolejnym razem się uda!");
    }
}
