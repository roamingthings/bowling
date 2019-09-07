package de.roamingthings.bowling;

import org.junit.jupiter.api.Test;

import static de.roamingthings.bowling.Game.GameFactory.toGame;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameFactoryTest {

    @Test
    void shouldConvertInput() {
        Game game = toGame("1, 2, 3");

        int pins = game.getPinsForMove(0);

        assertThat(pins).isEqualTo(1);
    }

    @Test
    void shouldRejectInputWithValuesTooSmall() {
        assertThatThrownBy(() -> toGame("1, 2, 3, -1"))
                .isInstanceOf(InvalidPinsValueException.class);
    }

    @Test
    void shouldRejectInputWithValuesTooBig() {
        assertThatThrownBy(() -> toGame("1, 2, 11, 3"))
                .isInstanceOf(InvalidPinsValueException.class);
    }

}
