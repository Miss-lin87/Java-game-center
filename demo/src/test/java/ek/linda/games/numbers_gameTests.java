package ek.linda.games;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class numbers_gameTests{
    numbers_game game = new numbers_game();

    @Test
    void make_chanses_test(){
        Assertions.assertEquals(6, game.make_chanses(3));
        Assertions.assertNotEquals(20, game.make_chanses(7));
        Assertions.assertEquals(45, game.make_chanses(42));
    }

    @Test
    void check_cows_test(){
        Assertions.assertEquals(4, game.check_cows(new ArrayList<>(List.of(1,5,7,9)), new ArrayList<>(List.of(1,7,5,9))));
        Assertions.assertNotEquals(4, game.check_cows(new ArrayList<>(List.of(2,9,5,8)), new ArrayList<>(List.of(4,7,5,9))));
        Assertions.assertEquals(3, game.check_cows(new ArrayList<>(List.of(1,5,7,9)), new ArrayList<>(List.of(4,7,5,9))));
    }

    @Test
    void check_bulls_test(){
        Assertions.assertEquals(2, game.check_bulls(new ArrayList<>(List.of(1,5,7,9)), new ArrayList<>(List.of(1,7,5,9))));
        Assertions.assertNotEquals(3, game.check_bulls(new ArrayList<>(List.of(2,9,5,8)), new ArrayList<>(List.of(4,7,5,9))));
        Assertions.assertEquals(4, game.check_bulls(new ArrayList<>(List.of(1,5,7,9)), new ArrayList<>(List.of(1,5,7,9))));
    }

    @Test
    void guess_test(){
        List<Integer> guess = game.make_array_guess("1465");
        Assertions.assertEquals(List.of(1,4,6,5), guess);
        Assertions.assertNotEquals(List.of(2,6,8,9), game.make_array_guess("8629"));
        Assertions.assertEquals(List.of(1,2,3,4), game.make_array_guess("1234"));
    }
}
