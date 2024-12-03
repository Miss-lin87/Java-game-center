package ek.linda;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class numbers_gameTests{

    @Test
    void make_chanses_test(){
        numbers_game game = new numbers_game();
        Assertions.assertEquals(6, game.make_chanses(3));
        Assertions.assertEquals(10, game.make_chanses(7));
    }

    @Test
    void check_cows_test(){
        numbers_game game = new numbers_game();
        List<Integer> guess = new ArrayList<>();
        Integer[] test = {1,5,7,9};
        guess.toArray(test);
        List<Integer> numbers = new ArrayList<>();
        Integer[] number = {4,7,5,9};
        numbers.toArray(number);
        Assertions.assertEquals(0, game.check_cows(guess, numbers));
    }
}
