package de.roamingthings.bowling;

public class BowlingRules {

    private static final int MAX_FRAME_NUMBER = 10;

    public static int pointsFor(Game game) {
        int currentFrame = 0;

        int currentMoveIndex = 0;
        int totalPoints = 0;
        while (currentFrame < MAX_FRAME_NUMBER) {
            if (game.isSpareFrameAt(currentMoveIndex)) {
                totalPoints += game.getSumOfSpareFrameAt(currentMoveIndex);
                currentMoveIndex += 2;
            } else {
                totalPoints += game.getSumOfOpenFrameAt(currentMoveIndex);
                currentMoveIndex += 2;
            }
            currentFrame++;
        }
        return totalPoints;
    }
}
