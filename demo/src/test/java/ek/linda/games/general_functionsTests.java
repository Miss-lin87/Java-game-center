package ek.linda.games;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class general_functionsTests {
    general_functions func = new general_functions();

    @Test
    void random_test(){
        Assertions.assertTrue(List.of(1,2,3,4,5,6,7,8,9,10).contains(general_functions.computer_random(10)));
        Assertions.assertFalse(List.of(10,22,33,44,55,66,77,88,99).contains(general_functions.computer_random(10)));
    }

    @Test
    void random_range_test(){
        Assertions.assertTrue(List.of(10,11,12,13,14,15,16,17,18,19,20).contains(general_functions.random_number_range(10, 20)));
        Assertions.assertFalse(List.of(22,33,44,55,6,7,8,9,99,77,66,55).contains(general_functions.random_number_range(10, 20)));
    }

    @Test
    void regex_spell_test(){
        String[] correct = {"Yes", "yes", "No", "no"};
        Assertions.assertEquals("Yes", general_functions.regex_spell_correct(correct, "Y"));
        Assertions.assertEquals("no", general_functions.regex_spell_correct(correct, "n"));
        Assertions.assertNotEquals("Ball", general_functions.regex_spell_correct(correct, "f"));
    }

    @Test
    void reqex_find_test(){
        Assertions.assertTrue(general_functions.regex_find_text("Yes", "Y"));
        Assertions.assertTrue(general_functions.regex_find_text("This is a test", "is"));
        Assertions.assertFalse(general_functions.regex_find_text("This can not find stuff", "Q"));
        Assertions.assertFalse(general_functions.regex_find_text("text_input", "find"));
    }

    @Test
    void hash_test(){
        Set<Integer> set = new HashSet<>(List.of(1,2,3,4,5,6,7,8,9,10));
        Assertions.assertEquals(set, general_functions.create_hash_int_range(1, 10));
        Assertions.assertNotEquals(set, general_functions.create_hash_int_range(10, 20));
    }
}
