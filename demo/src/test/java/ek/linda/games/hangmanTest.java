package ek.linda.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class hangmanTest {
    hangman game = new hangman();

    @Test
    void make_hidden_test(){
        String mock = game.make_hidden_word("cat");
        Assertions.assertEquals("___", mock);
        Assertions.assertNotEquals("____", mock);
    }

    @Test
    void reveal_test(){
        String mock = "cat";
        Assertions.assertTrue("_a_".equals(game.reveal_word("a", mock, "___")));
        Assertions.assertTrue("c__".equals(game.reveal_word("c", mock, "___")));
        Assertions.assertTrue("__t".equals(game.reveal_word("t", mock, "___")));
        Assertions.assertFalse("__t".equals(game.reveal_word("a", mock, "___")));
        Assertions.assertFalse("_c_".equals(game.reveal_word("c", mock, "___")));
    }

    @Test
    void test_start(){
        Assertions.assertEquals(6, game.game_setup("cat"));
        Assertions.assertEquals(7, game.game_setup("lion"));
        Assertions.assertNotEquals(7, game.game_setup("cat"));
        Assertions.assertNotEquals(2, game.game_setup("lion"));
    }
}
