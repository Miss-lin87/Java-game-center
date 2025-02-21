package ek.linda.games;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ek.linda.Game;

public class numbers_game implements Game{

    @Override
    public void run_game(){
        /** This function just runs the game. Calls numbers_game_Start on call.
         */
        numbers_game_start();
    }

    int difficualty(){
        /**this function takes no input. Will ask the player to pick a dificalty.
         * Easy 4 numbers total
         * Medium 6 numbers total
         * Hard 8 numbers total
         * This will outfpu 4,6,8 as int
         */
        int lengh_numbers = 0;
        String[] options = {"Easy", "Medium", "Hard"};
        switch (general_functions.regex_spell_correct(options, general_functions.ask_the_player("""
                                                What difucualty do you want to pay on:
                                                Easy: 4 numbers total
                                                Medium: 6 numbers total
                                                Hard: 8 numbers total"""))){
            case "Easy" -> lengh_numbers = 4;
            case "Medium" -> lengh_numbers = 6;
            case "Hard" -> lengh_numbers = 8;
        }
        return lengh_numbers;
    }

    List<Integer> numbers_array(int lengh_numbers){
        /**this wil make a List<Integer> from 1 to 10.
         * The input is the length of the numbers genereated.
         * This number comes from the dificualty the player picks in the difficualty function
         */
        List<Integer> numbers = new ArrayList<>();
        do { 
            numbers.add(general_functions.random_number_range(0, 10));
            lengh_numbers --;
        } while (lengh_numbers > 0);
        return numbers;
    }

    List<Integer> make_array_guess(String guess) {
        /** All this function will do is to parse the guess from the player to a List<Integer> */
        List<Integer> guessarray = new ArrayList<>();
        for (String elem : guess.split("")) {
            guessarray.add(Integer.valueOf(elem));
        }
        return guessarray;
    }
    
    int check_cows(List<Integer> guess, List<Integer> numbers){
        /** this checks the cows.
         * A cow is a number from the gusst number that is also in the number combination
         * the position do not matter. 
         * This function returns all cows even if they are bulls also
         */
        int cows = 0;
        for (Integer number : numbers) {
            if (guess.contains(number)){
                cows ++;
            }
        }
        return cows;
    }
    
    int check_bulls(List<Integer> guess, List<Integer> numbers){
        /** this finction checks the number of bulls, that is numbers from the guess that is in the number
         * and also in the correct possiton.
         * Will return all bulls.
         */
        int bulls = 0;
        for (Object number : numbers) {
            if (Objects.equals(numbers.get(numbers.indexOf(number)), guess.get(numbers.indexOf(number)))){
                bulls ++;
            }
        }
        return bulls;
    }

    int make_chanses(int difficualty){
        /** this function makes chanses.
         * Chanses are equal to the difficualty+3
         */
        int chanses = difficualty+3;
        return chanses;
    }

    boolean game_loop(List<Integer> numbers, int chanses){
        /** this starts the game loop where the chanes are printed and reduces on a guess.
         * this will also ask the player for a gusss of four numbers and compare it to the number
         * will print the number of cows and bulls. 
         * This is where the bulls are subtracted from the cows.
         * Returns false if chanses == 0 or true if the guess == number
         */
        int bulls;
        if (chanses == 0) {
            return false;
        }   
        do {
            System.out.println("You have " + chanses + " chanses left.");
            List<Integer> guess = make_array_guess(general_functions.ask_the_player("Please make a guess of " + numbers.size() + " numbers."));
            System.out.println("Number of correct quesses:\nCows: " + check_cows(guess, numbers) + "\nBulls: " + check_bulls(guess, numbers));
            bulls = check_bulls(guess, numbers);
            chanses --;
        } while (chanses > -1 & bulls != numbers.size());
    return true;
    }

    void numbers_game_start() {
        /** This function starts the game loop. Will make a new call fo the numbers game and then give direction
         * ask for the dificualty. Make the chanses and the secret number.
         * After this the game loop will be called
         * regardless of game loop giving true or false it will ask for a new game.
         */
        numbers_game game = new numbers_game();
        System.out.println("Welcome to a game of Cows and Bulls.");
        boolean game_on = true;
        int level = game.difficualty();
        do {
            System.out.println((game.game_loop(game.numbers_array(level), game.make_chanses(level))) ? "Concratulations. You wil" : "Sorry. You lose");
            if (!general_functions.regex_find_text("Yes, yes",(general_functions.ask_the_player("Play again? Yes/No")))){game_on=false;}
            else {
                numbers_game_start();
            }
        } while (game_on == true);
    }
}