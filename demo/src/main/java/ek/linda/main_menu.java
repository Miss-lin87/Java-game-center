package ek.linda;

import java.util.Map;

import ek.linda.games.general_functions;
import ek.linda.games.guess_number;
import ek.linda.games.hangman;
import ek.linda.games.numbers_game;
import ek.linda.games.rock_papper_scissors;

public class main_menu{

    public static void main(String[] args) {
        /**This is the main game function. This will ask the player for a specific game and then call on that game bases on a HashMap.
          Whenever the player is returned to the function it will ask if the player wants to play a new game.
         */
        String[] options = {"Guess the number","Hangman","Rock Paper scissors","Numbers game"};
        boolean game_on = true;
        Map<String, Game> games = Map.of("Guess the number", new guess_number(), "Hangman", new hangman(), "Rock paper scissors", new rock_papper_scissors(), "Numbers game", new numbers_game());
        do{
            System.out.println("Games:\n" + games.keySet());
            games.get(general_functions.regex_spell_correct(options ,general_functions.ask_the_player("select game"))).run_game();
            if (!general_functions.regex_find_text("Yes, yes",(general_functions.ask_the_player("Do you want to play a new game? Yes/No")))){
                game_on=false;
            }
        }
        while (game_on);
    }
}