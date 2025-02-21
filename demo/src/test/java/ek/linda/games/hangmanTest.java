package ek.linda.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class hangmanTest {
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
        Assertions.assertEquals("_a_", game.reveal_word("a", mock, "___"));
        Assertions.assertEquals("c__", game.reveal_word("c", mock, "___"));
        Assertions.assertEquals("__t", game.reveal_word("t", mock, "___"));
        Assertions.assertNotEquals("__t", game.reveal_word("a", mock, "___"));
        Assertions.assertNotEquals("_c_", game.reveal_word("c", mock, "___"));
    }

    @Test
    void test_start(){
        Assertions.assertEquals(6, game.game_setup("cat"));
        Assertions.assertEquals(7, game.game_setup("lion"));
        Assertions.assertNotEquals(7, game.game_setup("cat"));
        Assertions.assertNotEquals(2, game.game_setup("lion"));
    }
}
