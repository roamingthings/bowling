package de.roamingthings.bowling;

import org.junit.jupiter.api.Test;

import static de.roamingthings.bowling.TestDataFactory.gameWithAllFramesOpen;
import static de.roamingthings.bowling.TestDataFactory.gameWithAllMovesZero;
import static de.roamingthings.bowling.TestDataFactory.gameWithSpare;
import static de.roamingthings.bowling.TestDataFactory.gameWithSpike;
import static org.assertj.core.api.Assertions.assertThat;

class BowlingRulesTest {

    @Test
    void shouldCalculateSumForGameWithAllZero() {
        Game game = gameWithAllMovesZero();

        int points = BowlingRules.pointsFor(game);

        assertThat(points).isEqualTo(0);
    }

    @Test
    void shouldCalculateGameWithAllFramesOpen() {
        Game game = gameWithAllFramesOpen();

        int points = BowlingRules.pointsFor(game);

        assertThat(points).isEqualTo(14);
    }

    @Test
    void shouldCalculateGameWithSpare() {
        Game game = gameWithSpare();

        int points = BowlingRules.pointsFor(game);

        assertThat(points).isEqualTo(34);
    }

    @Test
    void shouldCalculateGameWithSpike() {
        Game game = gameWithSpike();

        int points = BowlingRules.pointsFor(game);

        assertThat(points).isEqualTo(61);
    }
}
