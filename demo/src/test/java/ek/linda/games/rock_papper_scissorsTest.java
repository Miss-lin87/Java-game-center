package ek.linda.games;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class rock_papper_scissorsTest {
    rock_papper_scissors game = new rock_papper_scissors();

    @Test
    void computer_pick_test(){
        List<String> options = new ArrayList<>(List.of("Rock", "Papper", "Scissors"));
        Assertions.assertTrue(options.contains(game.computer_pick()));
        Assertions.assertFalse("rock".equals(game.computer_pick()));
        Assertions.assertFalse("cat".equals(game.computer_pick()));
        Assertions.assertFalse("papper".equals(game.computer_pick()));
    }

    @Test
    void test(){
        Assertions.assertEquals("Its a draw", game.comparison("Rock", "Rock"));
        Assertions.assertEquals("You win", game.comparison("Rock", "Papper"));
        Assertions.assertEquals("You win", game.comparison("Papper", "Scissors"));
        Assertions.assertEquals("You lose", game.comparison("Papper", "Rock"));
    }

    @Test
    void player_choise_test(){
        Assertions.assertEquals("Rock", game.valid_player("Rock"));
        Assertions.assertEquals("Papper", game.valid_player("Papper"));
        Assertions.assertEquals("Scissors", game.valid_player("Scissors"));
    }
}