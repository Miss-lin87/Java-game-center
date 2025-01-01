package ek.linda.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class guess_numberTest {
    guess_number game = new guess_number();

    @Test
    void test_lowORhigh(){
        Assertions.assertTrue("Guess is to High\n".equals(game.higher_or_lower(10, 15)));
        Assertions.assertTrue("Guess is to Low\n".equals(game.higher_or_lower(10, 5)));
        Assertions.assertFalse("Guess is to High\n".equals(game.higher_or_lower(10, 5)));
        Assertions.assertFalse("Guess is to Low\n".equals(game.higher_or_lower(10, 15)));
    }
}
