package ek.linda;

import java.util.Map;

public class main_menu{

    public static void main(String[] args) {
        String[] options = {"Guess the number","Hangman","Rock papper scissors","Numbers game"};
        boolean game_on = true;
        Map<String, Game> games = Map.of("Guess the number", new guess_number(), "Hangman", new hangman(), "Rock papper scissors", new rock_papper_scissors(), "Numbers game", new numbers_game());
        do{
        System.out.println("Games:\n" + games.keySet());
        games.get(general_functions.regex_spell_correct(options ,general_functions.ask_the_player("select game"))).run_game();
        if (!general_functions.regex_find_text("Yes, yes",(general_functions.ask_the_player("Do you want to play a new game? Yes/No")))){game_on=false;}
        }
        while (game_on==true);
    }
}