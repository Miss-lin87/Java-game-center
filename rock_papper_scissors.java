import java.util.ArrayList;

public class rock_papper_scissors {
    static String valid_player(String player_choise){
        ArrayList<String> player_inputs = new ArrayList<>();
        player_inputs.add("Rock");
        player_inputs.add("Papper");
        player_inputs.add("Scissors");
        if (!player_inputs.contains(player_choise)) {
            return valid_player(general_functions.ask_the_player("Invalid input. \nPlease slect Rock, Papper or Scissors"));
        }
        else {}
    return player_choise;}

    static String computer_pick(){
        int number = general_functions.computer_random(3);
        String pick = null;
        switch (number){
            case 0 -> pick = "Rock";
            case 1 -> pick = "Papper";
            case 2 -> pick = "Scissors";
        }
        return pick;}

    static String comparison(String computer, String player){
        String result;
        if (computer.equals(player)){
            result = "Its a draw";}
        else if ("Rock".equals(player) & "Scissors".equals(computer) | "Scissors".equals(player) & "Papper".equals(computer) | "Papper".equals(player) & "Rock".equals(computer)){
            result = "You win";}
        else{
            result = "You lose";}
    return result;}

public static void main(String[] args) {
    System.out.println("Welcome to Rock, Papper, Scissors");
    boolean game_on = true;
    while (game_on == true){
        String player_input = valid_player(general_functions.ask_the_player("Please slect Rock, Papper or Scissors"));
        String computer_input = computer_pick();
        System.out.println("The computer picked: " + computer_input + "\n" + comparison(computer_input, player_input));
    if (!general_functions.regex_find_text("Yes, yes",(general_functions.ask_the_player("Keep playing? Yes/No")))){game_on=false;}
    else {}
    }
}
}