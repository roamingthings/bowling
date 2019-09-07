package de.roamingthings.bowling;

import static de.roamingthings.bowling.Game.GameFactory.toGame;

class TestDataFactory {
    static Game gameWithAllMovesZero() {
        return toGame(new int[]{
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0
        });
    }

    static Game gameWithAllFramesOpen() {
        return toGame(new int[]{
                1, 4,
                4, 5,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0
        });
    }

    static Game gameWithSpare() {
        return toGame(new int[]{
                1, 4,
                4, 5,
                6, 4,
                5, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0,
                0, 0
        });
    }

    static Game gameWithSpike() {
        return toGame(new int[]{
                1, 4,
                4, 5,
                6, 4,
                5, 5,
                10,
                0, 1,
                0, 0,
                0, 0,
                0, 0,
                0, 0
        });
    }
}
