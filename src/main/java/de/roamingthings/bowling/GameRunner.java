package de.roamingthings.bowling;

import java.util.Scanner;

import static de.roamingthings.bowling.Game.GameFactory.toGame;
import static java.lang.String.format;

public class GameRunner {
    public static void main(String[] args) {
        System.out.println("Bitte geben Sie die Ergebnisse der Würfe als kommaseparierte Liste ein:");

        String line = readLine();

        try {
            int points = BowlingRules.pointsFor(toGame(line));

            System.out.println(format("Die Gesamtpunktzahl beträgt %d Punkte", points));
        } catch (InvalidPinsValueException e) {
            System.out.println("Es wurden ungültige Werte für einzelne Werte eingegeben." +
                    " Sie müssen zwischen 0 und 10 liegen");
        } catch (NumberFormatException e) {
            System.out.println("Bitte geben Sie nur die Anzahl der Pins getrennt durch Komma ein.");
        }
    }

    private static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
