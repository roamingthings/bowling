package de.roamingthings.bowling;

public class BowlingRules {

    private static final int MAX_FRAME_NUMBER = 10;

    public static int pointsFor(Game game) {
        int currentMoveIndex = 0;
        int totalPoints = 0;

        for (int currentFrame = 1; currentFrame <= MAX_FRAME_NUMBER; currentFrame++) {
            if (game.isSpikeFrameAt(currentMoveIndex)) {
                totalPoints += game.getSumOfSpikeFrameAt(currentMoveIndex);
                currentMoveIndex += numberOfMovesToAdvanceForSpike(currentFrame);
            } else if (game.isSpareFrameAt(currentMoveIndex)) {
                totalPoints += game.getSumOfSpareFrameAt(currentMoveIndex);
                currentMoveIndex += numberOfMovesToAdvanceForSpare(currentFrame);
            } else {
                totalPoints += game.getSumOfOpenFrameAt(currentMoveIndex);
                currentMoveIndex += 2;
            }
        }

        failIfMovesLeft(game, currentMoveIndex);

        return totalPoints;
    }

    private static int numberOfMovesToAdvanceForSpare(int frameNumber) {
        return isLastFrame(frameNumber)? 3: 2;
    }

    private static int numberOfMovesToAdvanceForSpike(int frameNumber) {
        return isLastFrame(frameNumber) ? 3 : 1;
    }

    private static boolean isLastFrame(int currentFrame) {
        return currentFrame == MAX_FRAME_NUMBER;
    }

    private static void failIfMovesLeft(Game game, int currentMoveIndex) {
        if (game.hasMovesBeginningWith(currentMoveIndex)) {
            throw new TooManyMovesException();
        }
    }
}
