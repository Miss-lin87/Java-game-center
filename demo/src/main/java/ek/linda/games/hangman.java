package ek.linda.games;
import java.util.Arrays;

import ek.linda.Game;

public class hangman implements Game{

    @Override
    public void run_game(){
        hangman_game();
    }
    
    String[] words(){
        /**Just a function that returns a String[] with a lot or words.
         * Can be expanded if needed.
         */
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
        /**returns a random word form the input String[] */
        return words[general_functions.random_number_range(0, words.length)];
    }
    
    String make_hidden_word(String Word){
        /**Returns a hidden word of the input word. The hidden word consists of only _ */
        String splitword = "";
        for (@SuppressWarnings("unused") String split : Word.split("")) {
            splitword += "_";
        }
        return splitword;
    }
    
    String reveal_word(String guess, String word, String hidden){
        /**Function to reveal the part of the word that was guessed. */
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
        /**This will welcome the player to the game and then output the words leanth+3
         * This is used to create the chanses the player will get.
         */
        System.out.println("Welcome to hangman. \nHint to the word is Animal");
        System.out.println("The computer has picked a word");
        return word.length()+3;
    }

    String game_loop(String word, String hidden, int chanses){
        /**The actual game loop. Takes in the hidden word, the actual word and the chanses.
         * Stops if the hidden word matches the word or if chanses goes to 0
         */
        int original_chanses = chanses;
        do{
            if (chanses == 0){
                return "Sorry you lose the game. \nThe secet word was " + word;
            }
            else {
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
        /**This calls the actial game. Picks a random word and makes the hidden variant of that word.
         * Will call the game setup function and after its finished ask for a new game.
         */
        String word = pick_random_word(words());
        boolean game_on = true;
        do {
            System.out.println(game_loop(word, make_hidden_word(word), game_setup(word)));
            if (!general_functions.regex_find_text("Yes, yes",(general_functions.ask_the_player("Play again? Yes/No")))){game_on=false;}
            else {hangman_game();}
        } while (game_on == true);
    }
}