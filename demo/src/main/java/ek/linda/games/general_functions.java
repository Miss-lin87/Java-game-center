package ek.linda.games;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class general_functions {
    public static String regex_spell_correct(String[] text_input, String text_player){
        /**This takes a String[] and the player input and compares if the player input
         * is in the given String. Used for options.
         */
        for (String elem : text_input) {
            if (regex_find_text(elem, text_player)){
                return elem;
            }
        }
        return "not found";
    }

    public static boolean regex_find_text(String text_input, String text_search){
        /**Simpel regex finder to find a specific input in the search text */
        Pattern sketcher = Pattern.compile(text_search);
        Matcher text = sketcher.matcher(text_input);
        return text.find();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static String ask_the_player(String text_output){
        /**A function to ask the player for an input.
         * The text output is the string the player will se. 
         * The output will convert the string the player enters to have the first letter capitalized.
         */
        Scanner player = new Scanner(System.in);
        System.out.println(text_output);
        String player_input = player.nextLine();
        return player_input.substring(0, 1).toUpperCase() + player_input.substring(1).toLowerCase();}
    
    public static int computer_random(int max){
        /**Just return a random number up to the input */
        return (int)(Math.random()*max);
    }

    public static int random_number_range(int start, int stop){
        /**loops until a random number higher than start is found and returns that */
        int value = (int)(Math.random()*stop);
        while (value < start){
            return random_number_range(start, stop);
        }
        return value;
    }

    public static HashSet<Integer> create_hash_int_range(int start, int stop){
        /**creates a HashSet of all the numbers from the start to the stop value */
        HashSet<Integer> range_hash = new HashSet<>();
        do {
            range_hash.add(start);
            start ++;
        }
        while (start<=stop);
        return range_hash;
    }
}