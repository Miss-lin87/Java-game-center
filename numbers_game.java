import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class numbers_game{

static int select_random_value(HashSet<Integer> range_hash,int start, int stop){
    Iterator<Integer> hash_iterator = range_hash.iterator();
    int selected_number = general_functions.random_number_range(start, stop);
    while (hash_iterator.hasNext()){
        int number = hash_iterator.next();
        if (number == selected_number){
            break;
        }
        else{}
    }
return selected_number;
}

static String higher_or_lower(int Computer, int Guess){
    String result = (Computer > Guess) ? "Guess is to Low\n" : "Guess is to High\n";
    return result;
}

static String loop_for_wining(Integer computer, Integer chanses){
        int original_chanses = chanses;
        String player_guess;
    do{
        if (chanses == 0){
            return "Sorry, you lose.";
        }
        else{
        player_guess = general_functions.ask_the_player(chanses + " chanses left\n" + "Make a quess of a number: ");
        System.out.println(higher_or_lower(computer, Integer.parseInt(player_guess)));
        chanses --;
        }
    }
    while (!Objects.equals(player_guess, computer.toString()));
    return "Congratulations you win. You needed " + (original_chanses - chanses) + " chanses";
}

static int select_dificualty(){
    String[] options = {"Hard", "Medium", "Easy"};
    int chanses = 0;
    String player_choise = general_functions.regex_spell_correct(options, general_functions.ask_the_player("Do you want to play on hard, medium or easy? "));
    switch (player_choise) {
        case "Hard" -> chanses = 5;
        case "Medium" -> chanses = 10;
        case "Easy" -> chanses = 15;}
    return chanses;
}

static int computer_select_random(){
    int selected_value = 0;
    try {
        selected_value = general_functions.random_number_range(Integer.parseInt(general_functions.ask_the_player("Please select the start of the range: ")),(Integer.parseInt(general_functions.ask_the_player("Please select the end of the range: "))));    
    } catch (StackOverflowError e) {
        if (general_functions.regex_find_text("Yes, yes", (general_functions.ask_the_player("Invalid input. \nWant to try again. Yes/No? ")))){
            computer_select_random();
        }
        else{System.exit(0);}
    }
    return selected_value;
}

public static void main(String[] args) {
    System.out.println("Welcome to the numbers game");
    boolean game_on=true;
    do {
        System.out.println(loop_for_wining(computer_select_random(), select_dificualty()));
            if (!general_functions.regex_find_text("Yes, yes",(general_functions.ask_the_player("Play again? Yes/No")))){game_on=false;}
            else {}
    } while (game_on=true);
    }
}