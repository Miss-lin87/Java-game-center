package ek.linda.games;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class general_functions {
    public static String regex_spell_correct(String[] text_input, String text_player){
        for (String elem : text_input) {
            if (regex_find_text(elem, text_player) == true){
                return elem;
            }
        }
        return "not found";
    }

    public static boolean regex_find_text(String text_input, String text_seartch){
        Pattern sertch = Pattern.compile(text_seartch);
        Matcher text = sertch.matcher(text_input);
        boolean found = text.find();
        return found;
    }

    public static String ask_the_player(String text_output){
        String player_input;
        Scanner player = new Scanner(System.in);
        System.out.println(text_output);
        player_input = player.nextLine();
        return player_input.substring(0, 1).toUpperCase() + player_input.substring(1).toLowerCase();}
    
    public static int computer_random(int max){
        int random_pick = (int)(Math.random()*max);
        return random_pick;
    }

    public static int random_number_range(int start, int stop){
        int value = (int)(Math.random()*stop);
        while (value < start){return random_number_range(start, stop);}
        return value;
    }

    public static HashSet<Integer> create_hash_int_range(int start, int stop){
        HashSet<Integer> range_hash = new HashSet<>();
        do {
            range_hash.add(start);
            start ++;
        }
        while (start<=stop);
        return range_hash;
    }
}