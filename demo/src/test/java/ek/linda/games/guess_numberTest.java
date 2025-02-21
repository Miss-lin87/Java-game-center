package ek.linda.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class guess_numberTest {
    guess_number game = new guess_number();

    @Test
    void test_lowORhigh() {
        Assertions.assertEquals("Guess is to High\n", game.higher_or_lower(10, 15));
        Assertions.assertEquals("Guess is to Low\n", game.higher_or_lower(10, 5));
        Assertions.assertNotEquals("Guess is to High\n", game.higher_or_lower(10, 5));
        Assertions.assertNotEquals("Guess is to Low\n", game.higher_or_lower(10, 15));
    }

    @Test
    void test_gameloop() {
        Assertions.assertEquals("Sorry, you lose.", game.loop_for_wining(5, 0));
        Assertions.assertEquals("Sorry, you lose.", game.loop_for_wining(15, 0));
        ByteArrayInputStream mock = new ByteArrayInputStream("1".getBytes());
        System.setIn(mock);
        Assertions.assertEquals("Sorry, you lose.", game.loop_for_wining(15,1));
    }

    @Test
    void test_difficalty() {
        ByteArrayInputStream mockEasy = new ByteArrayInputStream("Easy".getBytes());
        ByteArrayInputStream mockMedium = new ByteArrayInputStream("Medium".getBytes());
        ByteArrayInputStream mockHard = new ByteArrayInputStream("Hard".getBytes());
        System.setIn(mockHard);
        Assertions.assertEquals(5, game.select_dificualty());
        System.setIn(mockMedium);
        Assertions.assertEquals(10, game.select_dificualty());
        System.setIn(mockEasy);
        Assertions.assertEquals(15, game.select_dificualty());
    }
}