package de.roamingthings.bowling;

import org.junit.jupiter.api.Test;

import static de.roamingthings.bowling.Game.GameFactory.toGame;
import static org.assertj.core.api.Assertions.assertThat;

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
}
