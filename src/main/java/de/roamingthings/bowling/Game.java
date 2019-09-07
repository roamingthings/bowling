package de.roamingthings.bowling;

import static java.util.Arrays.stream;

public class Game {

    private final int[] moves;

    public static Game fromInput(String input) {
        return new Game(convertToArray(input));
    }

    private static int[] convertToArray(String input) {
        return stream(input.split(","))
                .map(String::trim)
                .mapToInt(Integer::new)
                .toArray();
    }

    private Game(int[] moves) {
        this.moves = moves;
    }

    public int getPinsForMove(int index) {
        return moves[index];
    }
}
