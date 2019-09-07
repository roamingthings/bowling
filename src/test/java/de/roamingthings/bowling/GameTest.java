package de.roamingthings.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    @Test
    void shouldConvertInput() {
        Game game = Game.fromInput("1, 2, 3");

        int pins = game.getPinsForMove(0);

        assertThat(pins).isEqualTo(1);
    }

    @Test
    void shouldRejectInputWithValuesTooSmall() {
        assertThatThrownBy(() -> Game.fromInput("1, 2, 3, -1"))
                .isInstanceOf(InvalidPinsValueException.class);
    }

    @Test
    void shouldRejectInputWithValuesTooBig() {
        assertThatThrownBy(() -> Game.fromInput("1, 2, 11, 3"))
                .isInstanceOf(InvalidPinsValueException.class);
    }

}
