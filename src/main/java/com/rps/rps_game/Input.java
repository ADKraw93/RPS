package com.rps.rps_game;

import java.util.Scanner;

public class Input {

    private static final Scanner sc = new Scanner(System.in);

    public static String nameInput() {
        System.out.println("Podaj swoje imię.");
        var name = sc.next();
        System.out.println("Witaj " + name + "!");
        return name;
    }

    public static int numberOfWinsInput() {
        System.out.println("Podaj do ilu zwycięstw chcesz grać?");
        var numberOfWins = sc.nextInt();
        System.out.println("Ok, zatem gramy do " + numberOfWins + " zwycięstw.");
        return numberOfWins;
    }

    public static String move() {
        return sc.next();
    }

}
