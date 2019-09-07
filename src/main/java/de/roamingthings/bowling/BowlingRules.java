package de.roamingthings.bowling;

public class BowlingRules {

    private static final int MAX_FRAME_NUMBER = 10;

    public static int pointsFor(Game game) {
        int currentMoveIndex = 0;
        int totalPoints = 0;

        for (int currentFrame = 0; currentFrame < MAX_FRAME_NUMBER - 1; currentFrame++) {
            if (game.isSpikeFrameAt(currentMoveIndex)) {
                totalPoints += game.getSumOfSpikeFrameAt(currentMoveIndex);
                currentMoveIndex += 1;
            } else if (game.isSpareFrameAt(currentMoveIndex)) {
                totalPoints += game.getSumOfSpareFrameAt(currentMoveIndex);
                currentMoveIndex += 2;
            } else {
                totalPoints += game.getSumOfOpenFrameAt(currentMoveIndex);
                currentMoveIndex += 2;
            }
        }

        if (game.isSpikeFrameAt(currentMoveIndex)) {
            totalPoints += game.getSumOfSpikeFrameAt(currentMoveIndex);
            currentMoveIndex += 3;
        } else if (game.isSpareFrameAt(currentMoveIndex)) {
            totalPoints += game.getSumOfSpareFrameAt(currentMoveIndex);
            currentMoveIndex += 3;
        } else {
            totalPoints += game.getSumOfOpenFrameAt(currentMoveIndex);
            currentMoveIndex += 2;
        }

        return totalPoints;
    }
}
