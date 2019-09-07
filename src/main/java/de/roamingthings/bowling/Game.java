package de.roamingthings.bowling;

import static java.util.Arrays.stream;

public class Game {

    private final int[] moves;

    public static Game fromInput(String input) {
        int[] moves = convertToArray(input);
        failOnInvalidValues(moves);
        return new Game(moves);
    }

    private static int[] convertToArray(String input) {
        return stream(input.split(","))
                .map(String::trim)
                .mapToInt(Integer::new)
                .toArray();
    }

    private static void failOnInvalidValues(int[] moves) {
        boolean invalidMoves = stream(moves).anyMatch(pins -> pins < 0 || pins > 10);
        if (invalidMoves) {
            throw new InvalidPinsValueException();
        }
    }


    private Game(int[] moves) {
        this.moves = moves;
    }

    public int getPinsForMove(int index) {
        return moves[index];
    }
}
