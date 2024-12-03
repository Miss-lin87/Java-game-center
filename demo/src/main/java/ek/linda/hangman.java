package ek.linda;
import java.util.Arrays;

public class hangman implements Game{

    @Override
    public String run_game(){
        hangman_game();
        return "";
    }
    
    String[] words(){
        String[] words = {"dog","cow","cat","horse","donkey","tiger","lion","panther",
                       "leopard","cheetah","bear","elephant","turtle","tortoise","crocodile",
                       "rabbit","porcupine","hare","hen","pigeon","albatross","crow","fish",
                       "dolphin","frog","whale","alligator","eagle","ostrich","fox",
                       "goat","jackal","emu","armadillo","eel","goose","wolf",
                       "beagle","gorilla","chimpanzee","monkey","beaver","orangutan","antelope","bat",
                       "badger","giraffe","panda","hamster","cobra","camel","hawk","deer","chameleon",
                       "hippopotamus","jaguar","chihuahua","cobra","ibex",
                       "lizard","koala","kangaroo","iguana","llama","chinchillas","dodo","jellyfish",
                       "rhinoceros","hedgehog","zebra","possum","wombat","bison","bull","buffalo",
                       "sheep","meerkat","mouse","otter","sloth","owl","vulture","flamingo",
                       "racoon","mole","duck","swan","lynx","lizard","elk","boar",
                       "lemur","mule","baboon","mammoth","whale","rat","snake","peacock"};
    return words;
    }
    
    String pick_random_word(String[] words){
        String random_pick;
        int number_of_words = 0;
        for (String elem : words) {
            number_of_words ++;
        }
        random_pick = words[general_functions.random_number_range(0, number_of_words)];
        return random_pick;
    }
    
    String make_hidden_word(String Word){
        String[] wordlist = Word.split("");
        String splitword = "";
        for (Object elem : wordlist) {
            splitword = splitword + "_";
        }
        return splitword;
    }
    
    String reveal_word(String guess, String word, String hidden){
        int index = 0;
        for (String letter : word.split("")) {
            if (guess.equals(letter)) {
                hidden = hidden.substring(0, index) + guess + hidden.substring(index+1);
                }
            index ++;
        }
        return hidden;
    }
    
    int game_setup(String word){
        System.out.println("Welcome to hangman. \nHint to the word is Animal");
        int guesses = (word.length()+3);
        System.out.println("The computer has picked a word");
        return guesses;
    }

    String game_loop(String word, String hidden, int chanses){
        int original_chanses = chanses;
        do{
            if (chanses == 0){
                return "Sorry you lose the game. \nThe secet word was " + word;}
            else{
                System.out.println("Total number of guesses left: " + chanses + "\n" + Arrays.toString(hidden.split("")));
                String guess = general_functions.ask_the_player("Please make a guess: ").toLowerCase();
                while (hidden.contains(guess)){
                    System.out.println("You have alreday guessed that letter. Try again");
                    guess = general_functions.ask_the_player("Please make a guess: ").toLowerCase();
                }
                hidden = reveal_word(guess, word, hidden);
                chanses = (word.contains(guess) ? chanses : chanses-1);
            }
        }
        while (chanses > -1 & hidden.contains("_"));
    return "Congratulations, you win.\nAnd it took you " + (original_chanses - chanses) + " tries";
    }

    void hangman_game() {
        hangman game = new hangman();
        String word = game.pick_random_word(game.words());
        boolean game_on = true;
        do {
            System.out.println(game.game_loop(word, game.make_hidden_word(word), game.game_setup(word)));
            if (!general_functions.regex_find_text("Yes, yes",(general_functions.ask_the_player("Play again? Yes/No")))){game_on=false;}
            else {hangman_game();}
        } while (game_on == true);
    }
}