package de.roamingthings.bowling;

import org.junit.jupiter.api.Test;

import static de.roamingthings.bowling.Game.GameFactory.toGame;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    @Test
    void shouldCalculateSumOfOpenFrame() {
        Game game = toGame(new int[]{
                1, 2,
                3, 4
        });

        int points = game.getSumOfOpenFrameAt(2);

        assertThat(points).isEqualTo(7);
    }

    @Test
    void shouldFailIfTooFewMovesLeft() {
        Game game = toGame(new int[]{
                1, 2,
                3, 4
        });

        assertThatThrownBy(() -> game.getSumOfOpenFrameAt(3))
                .isInstanceOf(TooFewMovesException.class);
    }

    @Test
    void shouldReturnTrueIfSparePresent() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4,
                7, 1
        });

        boolean found = game.isSpareFrameAt(2);

        assertThat(found).isTrue();
    }

    @Test
    void shouldReturnTrueIfSparePresentAtTheEnd() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4,
                5, 5
        });

        boolean found = game.isSpareFrameAt(4);

        assertThat(found).isTrue();
    }

    @Test
    void shouldReturnFalseIfSpareAbsent() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4,
                7, 1
        });

        boolean found = game.isSpareFrameAt(0);

        assertThat(found).isFalse();
    }

    @Test
    void shouldReturnFalseIfTooFewMoves() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4,
                7, 1
        });

        boolean found = game.isSpareFrameAt(5);

        assertThat(found).isFalse();
    }
}
