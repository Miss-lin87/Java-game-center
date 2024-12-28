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
}
