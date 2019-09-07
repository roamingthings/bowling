package de.roamingthings.bowling;

import org.junit.jupiter.api.Test;

import static de.roamingthings.bowling.TestDataFactory.gameWithAllFramesOpen;
import static de.roamingthings.bowling.TestDataFactory.gameWithAllMovesZero;
import static org.assertj.core.api.Assertions.assertThat;

class BowlingRulesTest {

    @Test
    void shouldCalculateSumForGameWithAllZero() {
        Game game = gameWithAllMovesZero();

        int points = BowlingRules.pointsFor(game);

        assertThat(points).isEqualTo(0);
    }

}
