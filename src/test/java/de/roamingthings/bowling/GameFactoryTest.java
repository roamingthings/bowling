package de.roamingthings.bowling;

import org.junit.jupiter.api.Test;

import static de.roamingthings.bowling.Game.GameFactory.toGame;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class GameFactoryTest {

    @Test
    void shouldConvertInput() {
        Game game = toGame("1, 2, 3");

        assertSoftly(softly -> {
            softly.assertThat(game.getPinsForMove(0)).isEqualTo(1);
            softly.assertThat(game.getPinsForMove(1)).isEqualTo(2);
            softly.assertThat(game.getPinsForMove(2)).isEqualTo(3);
        });
    }

    @Test
    void shouldCreateFromArray() {
        Game game = toGame(new int[] {3, 4, 5});

        assertSoftly(softly -> {
            softly.assertThat(game.getPinsForMove(0)).isEqualTo(3);
            softly.assertThat(game.getPinsForMove(1)).isEqualTo(4);
            softly.assertThat(game.getPinsForMove(2)).isEqualTo(5);
        });
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
