package de.roamingthings.bowling;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static de.roamingthings.bowling.Game.GameFactory.toGame;
import static org.assertj.core.api.Assumptions.assumeThat;

@Disabled
class UserAcceptanceTests {
    
    @Test
    void shouldCalculateAssignment() {
        // Ausgefuehrte Wuerfe
        int[] moves = {
                1, 4,
                4, 5,
                6, 4,   // (Spare)
                5, 5,   // (Spare)
                10,     // (Strike)
                0, 1,   //
                7, 3,   // (Spare)
                6, 4,   // (Spare)
                10,     // (Strike)

                2, 8,   // (Spare)
                6
        };

        int points = BowlingRules.pointsFor(toGame(moves));

        // Gesamtsumme: 133
        assumeThat(points).isEqualTo(133);
    }

    @Test
    void shouldCalculatePerfectGame() {
        // Ausgefuerte Wuerfe
        int[] moves = {
                10, // (Strike)
                10, // (Strike)
                10, // (Strike)
                10, // (Strike)
                10, // (Strike)
                10, // (Strike)
                10, // (Strike)
                10, // (Strike)
                10, // (Strike)

                10, // (Strike)
                10, // (Strike)
                10, // (Strike)

        };

        int points = BowlingRules.pointsFor(toGame(moves));

        // Gesamtsumme: 200
        assumeThat(points).isEqualTo(300);
    }

    @Test
    void shouldCalculateBowlingWissenGame() {
        // https://www.bowling-wissen.de/regeln/punktezaehlung/
        // Ausgefuerte Wuerfe
        int[] moves = {
                9, 1,   // (Spare)
                8, 2,   // (Spare)
                10,     // (Strike)
                9, 1,   // (Spare)
                8, 0,
                8, 2,   // (Spare)
                9, 0,
                10,     // (Strike)
                10,     // (Strike)

                10,     // (Strike)
                9, 1    // (Spare)
        };

        int points = BowlingRules.pointsFor(toGame(moves));

        // Gesamtsumme: 191
        assumeThat(points).isEqualTo(191);
    }
}
