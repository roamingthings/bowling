package de.roamingthings.bowling;

import static java.util.Arrays.stream;

public class Game {

    public static class GameFactory {

        private GameFactory() {
        }
        public static Game toGame(int[] moves) {
            failOnInvalidValues(moves);
            return new Game(moves);
        }

        public static Game toGame(String input) {
            return toGame(convertToArray(input));
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

    }
    private final int[] moves;

    private Game(int[] moves) {
        this.moves = moves;
    }

    public int getPinsForMove(int index) {
        return moves[index];
    }

    public int getSumOfOpenFrameAt(int firstMoveOfFrame) {
        if (firstMoveOfFrame > moves.length - 2) {
            throw new TooFewMovesException();
        }
        return moves[firstMoveOfFrame] + moves[firstMoveOfFrame + 1];
    }
}
