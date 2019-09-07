package de.roamingthings.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void shouldConvertInput() {
        Game game = Game.fromInput("1, 2, 3");

        int pins = game.getPinsForMove(0);

        assertThat(pins).isEqualTo(1);
    }
}
