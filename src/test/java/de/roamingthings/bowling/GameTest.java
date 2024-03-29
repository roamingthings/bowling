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
    void shouldFailIfTooFewMovesLeftForSumOfOpenFrame() {
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
    void shouldReturnFalseIfTooFewMovesForSpare() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4,
                7, 1
        });

        boolean found = game.isSpareFrameAt(5);

        assertThat(found).isFalse();
    }

    @Test
    void shouldCalculateSumOfSpareFrame() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4,
                5, 2
        });

        int points = game.getSumOfSpareFrameAt(2);

        assertThat(points).isEqualTo(15);
    }

    @Test
    void shouldFailIfTooFewMovesLeftForSumOfSpareFrame() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4
        });

        assertThatThrownBy(() -> game.getSumOfSpareFrameAt(2))
                .isInstanceOf(TooFewMovesException.class);
    }

    @Test
    void shouldReturnTrueIfStrikePresent() {
        Game game = toGame(new int[]{
                1, 2,
                10,
                7, 1
        });

        boolean found = game.isSpikeFrameAt(2);

        assertThat(found).isTrue();
    }

    @Test
    void shouldReturnTrueIfStrikePresentAtTheEnd() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4,
                10
        });

        boolean found = game.isSpikeFrameAt(4);

        assertThat(found).isTrue();
    }

    @Test
    void shouldReturnFalseIfStrikeAbsent() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4,
                7, 1
        });

        boolean found = game.isSpikeFrameAt(0);

        assertThat(found).isFalse();
    }

    @Test
    void shouldReturnFalseIfTooFewMovesForSpike() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4,
                7, 1
        });

        boolean found = game.isSpikeFrameAt(6);

        assertThat(found).isFalse();
    }


    @Test
    void shouldCalculateSumOfSpikeFrame() {
        Game game = toGame(new int[]{
                1, 2,
                10,
                5, 2
        });

        int points = game.getSumOfSpikeFrameAt(2);

        assertThat(points).isEqualTo(17);
    }

    @Test
    void shouldFailIfTooFewMovesLeftForSumOfSpikeFrame() {
        Game game = toGame(new int[]{
                1, 2,
                10,
                4
        });

        assertThatThrownBy(() -> game.getSumOfSpikeFrameAt(2))
                .isInstanceOf(TooFewMovesException.class);
    }

    @Test
    void shouldReturnTrueIfMovesExistAfterIndex() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4
        });

        boolean found = game.hasMovesBeginningWith(3);

        assertThat(found).isTrue();
    }

    @Test
    void shouldReturnFalseIfMovesAbsentAfterIndex() {
        Game game = toGame(new int[]{
                1, 2,
                6, 4
        });

        boolean found = game.hasMovesBeginningWith(4);

        assertThat(found).isFalse();
    }
}
