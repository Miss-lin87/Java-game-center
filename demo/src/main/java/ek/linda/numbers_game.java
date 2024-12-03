package ek.linda;
import java.util.ArrayList;
import java.util.List;

public class numbers_game implements Game{

    @Override
    public String run_game(){
        numbers_game_start();
        return "";
    }
    int difficualty(){
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
        List<Integer> numbers = new ArrayList<>();
        do { 
            numbers.add(general_functions.random_number_range(0, 10));
            lengh_numbers --;
        } while (lengh_numbers > 0);
        return numbers;
    }

    List<Integer> make_array_guess(String guess){
        List<Integer> guessarray = new ArrayList<>();
        for (Object elem : guess.split("")) {
            guessarray.add(Integer.getInteger(elem.toString()));
        }
        return guessarray;
    }
    
    int check_cows(List<Integer> guess, List<Integer> numbers){
        int cows = 0;
        for (Object number : numbers) {
            if (guess.contains(number)){
                cows ++;
            }
        }
        return cows;
    }
    
    int check_bulls(List<Integer> guess, List<Integer> numbers){
        int bulls = 0;
        int index = 0;
        for (Object number : numbers) {
            if (numbers.get(index) == guess.get(index)){
                bulls ++;
                index ++;
            }
        }
        return bulls;
    }

    int make_chanses(int difficualty){
        int chanses = difficualty+3;
        return chanses;
    }

    boolean game_loop(List<Integer> numbers, int chanses){
        int bulls = 0;
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
        numbers_game game = new numbers_game();
        System.out.println("Welcome to a game of Cows and Bulls.");
        boolean game_on = true;
        int level = game.difficualty();
        do {
            System.out.println((game.game_loop(game.numbers_array(level), game.make_chanses(level))) ? "Concratulations. You wil" : "Sorry. You lose");
            if (!general_functions.regex_find_text("Yes, yes",(general_functions.ask_the_player("Play again? Yes/No")))){game_on=false;}
            else {numbers_game_start();}
        } while (game_on == true);
    }
}