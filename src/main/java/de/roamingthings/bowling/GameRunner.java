package de.roamingthings.bowling;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        System.out.println("Bitte geben Sie die Ergebnisse der Würfe als kommaseparierte Liste ein:");

        String line = readLine();
    }

    private static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
