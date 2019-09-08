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

            System.out.println(format("Die Gesamtpunktzahl beträgt %d Punkte.", points));
        } catch (TooFewMovesException e) {
            System.out.println("Es wurden nicht genügend Würfe eingegeben.");
        } catch (TooManyMovesException e) {
            System.out.println("Es wurden zu viele Würfe eingegeben. Bitte geben Sie im 10. Frame nur die tatsächlich" +
                    "ausgeführten Würfe ein.");
        } catch (InvalidPinsValueException e) {
            System.out.println("Es wurden ungültige Werte für einzelne Werte eingegeben." +
                    " Sie müssen zwischen 0 und 10 liegen.");
        } catch (NumberFormatException e) {
            System.out.println("Bitte geben Sie nur die Anzahl der Pins getrennt durch Komma ein.");
        }
    }

    private static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
