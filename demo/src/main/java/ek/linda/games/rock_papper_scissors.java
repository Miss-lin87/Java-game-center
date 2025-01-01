package ek.linda.games;
import java.util.ArrayList;
import java.util.List;

import ek.linda.Game;

public class rock_papper_scissors implements Game {

    @Override
    public void run_game(){
        RPS_game();
    }

    String valid_player(String player_choise){
        /**Function to se if the players choise is in the list of options.
         * Rock, Papper or Scissors.
         * If not the function aks the player to enter again and loops.
         */
        ArrayList<String> player_inputs = new ArrayList<>(List.of("Rock", "Papper", "Scissors"));
        if (!player_inputs.contains(player_choise)) {
            return valid_player(general_functions.ask_the_player("Invalid input. \nPlease slect Rock, Papper or Scissors"));
        }
    return player_choise;
    }

    String computer_pick(){
        /**Switch case from 0-2 and dependning on the outcome that is the string that will be retirned. 
         * Rock, Papper or Scissors.
         */
        String pick = null;
        switch (general_functions.computer_random(3)){
            case 0 -> pick = "Rock";
            case 1 -> pick = "Papper";
            case 2 -> pick = "Scissors";
        }
        return pick;
    }

    String comparison(String computer, String player){
        /**Actual function to check the computers choise towards the player chosse.
         * Outcomes are draw, win or loss.
         */
        String result;
        if (computer.equals(player)){
            result = "Its a draw";
        }
        else if ("Rock".equals(player) & "Scissors".equals(computer) | "Scissors".equals(player) & "Papper".equals(computer) | "Papper".equals(player) & "Rock".equals(computer)){
            result = "You win";
        }
        else{
            result = "You lose";
        }
    return result;
    }

    void RPS_game() {
        /**Function to run the game. Welcomes the player to the game and askes for an input.
         * Regardless of win or loss askes for a new game.
         */
        System.out.println("Welcome to Rock, Papper, Scissors");
        boolean game_on = true;
        while (game_on == true){
            String computer_input = computer_pick();
            System.out.println("The computer picked: " + computer_input + "\n" + comparison(computer_input, valid_player(general_functions.ask_the_player("Please slect Rock, Papper or Scissors"))));
        if (!general_functions.regex_find_text("Yes, yes",(general_functions.ask_the_player("Keep playing? Yes/No")))){game_on=false;}
        }
    }
}