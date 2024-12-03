package ek.linda;
import java.util.ArrayList;

public class rock_papper_scissors implements Game {

    @Override
    public String run_game(){
        RPS_game();
        return "";
    }

    String valid_player(String player_choise){
        ArrayList<String> player_inputs = new ArrayList<>();
        player_inputs.add("Rock");
        player_inputs.add("Papper");
        player_inputs.add("Scissors");
        if (!player_inputs.contains(player_choise)) {
            return valid_player(general_functions.ask_the_player("Invalid input. \nPlease slect Rock, Papper or Scissors"));
        }
    return player_choise;}

    String computer_pick(){
        int number = general_functions.computer_random(3);
        String pick = null;
        switch (number){
            case 0 -> pick = "Rock";
            case 1 -> pick = "Papper";
            case 2 -> pick = "Scissors";
        }
        return pick;}

    String comparison(String computer, String player){
        String result;
        if (computer.equals(player)){
            result = "Its a draw";}
        else if ("Rock".equals(player) & "Scissors".equals(computer) | "Scissors".equals(player) & "Papper".equals(computer) | "Papper".equals(player) & "Rock".equals(computer)){
            result = "You win";}
        else{
            result = "You lose";}
    return result;}

    void RPS_game() {
        rock_papper_scissors game = new rock_papper_scissors();
        System.out.println("Welcome to Rock, Papper, Scissors");
        boolean game_on = true;
        while (game_on == true){
            String player_input = game.valid_player(general_functions.ask_the_player("Please slect Rock, Papper or Scissors"));
            String computer_input = game.computer_pick();
            System.out.println("The computer picked: " + computer_input + "\n" + game.comparison(computer_input, player_input));
        if (!general_functions.regex_find_text("Yes, yes",(general_functions.ask_the_player("Keep playing? Yes/No")))){game_on=false;}
        }
    }
}