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
        if (lessThanTwoMovesLeftAt(firstMoveOfFrame)) {
            throw new TooFewMovesException();
        }
        return moves[firstMoveOfFrame] + moves[firstMoveOfFrame + 1];
    }

    public boolean isSpareFrameAt(int firstMoveOfFrame) {
        if (twoMovesLeftAt(firstMoveOfFrame)) {
            return (moves[firstMoveOfFrame] + moves[firstMoveOfFrame + 1]) == 10;
        }
        return false;
    }

    public int getSumOfSpareFrameAt(int firstMoveOfFrame) {
        if (lessThanThreeMovesLeftAt(firstMoveOfFrame)) {
            throw new TooFewMovesException();
        }
        return moves[firstMoveOfFrame] + moves[firstMoveOfFrame + 1] + moves[firstMoveOfFrame + 2];
    }

    public boolean isSpikeFrameAt(int firstMoveOfFrame) {
        if (oneMoveLeftAt(firstMoveOfFrame)) {
            return moves[firstMoveOfFrame] == 10;
        }
        return false;
    }

    public int getSumOfSpikeFrameAt(int firstMoveOfFrame) {
        return getSumOfSpareFrameAt(firstMoveOfFrame);
    }

    public boolean hasMovesBeginningWith(int index) {
        return index < moves.length;
    }

    private boolean lessThanTwoMovesLeftAt(int firstMoveOfFrame) {
        return firstMoveOfFrame > moves.length - 2;
    }

    private boolean lessThanThreeMovesLeftAt(int firstMoveOfFrame) {
        return firstMoveOfFrame > moves.length - 3;
    }

    private boolean oneMoveLeftAt(int firstMoveOfFrame) {
        return firstMoveOfFrame <= moves.length - 1;
    }

    private boolean twoMovesLeftAt(int firstMoveOfFrame) {
        return firstMoveOfFrame <= moves.length - 2;
    }
}
