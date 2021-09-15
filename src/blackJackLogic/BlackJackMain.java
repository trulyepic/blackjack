package blackJackLogic;

import java.util.Scanner;

public class BlackJackMain {

    public static void main(String[] args){

        //will get an concurrent exception after about 5 to 6 runs
        new BlackJack().playGame();
//        Scanner scanUserInput = new Scanner(System.in);
//        System.out.print("Do you want to play a game of Blackjack? Type 'y' or 'n': ");
//        String userInput = scanUserInput.nextLine();
//        if(userInput.equalsIgnoreCase("y")){
//            new BlackJack().playGame();
//        }
    }
}
