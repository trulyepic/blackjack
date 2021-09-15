package blackJackLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    //cards are infinite -> can add logic to remove cards from array after dealing them to player or computer
    //logic should be added to the dealCards()
    private int[] cards = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    private List<Integer> userCards = new ArrayList<>();
    private List<Integer> computerCards = new ArrayList<>();
    private int userScore;
    private int computerScore;
    private boolean isGameOver;

    Scanner scanUserInput = new Scanner(System.in);
    String userInput;

    public void playGame(){
        //add random cards to user
        for(int i = 0; i<2; i++) {
            userCards.add(dealCards());
            computerCards.add(dealCards());
        }
        while(!isGameOver) {
            userScore = calculateScore(userCards);
            computerScore = calculateScore(computerCards);

            System.out.println("your cards: " + userCards + ", current score: " + userScore);
            System.out.println("Computer's first card: " + computerCards.get(0));

            if (userScore == 0 || computerScore == 0 || userScore > 21) {
                isGameOver = true;
            }else{
                System.out.print("Type 'y' to get another card, type 'n' to pass: ");
                userInput = scanUserInput.nextLine();
                if(userInput.equalsIgnoreCase("y")){
                    userCards.add(dealCards());
                } else{
                    isGameOver = true;
                }
            }
        }

        //computer turn if user opts to not draw another card
        while(computerScore !=0 && computerScore <17){
            computerCards.add(dealCards());
            computerScore = calculateScore(computerCards);
        }

        System.out.println("Your final hand: "+ userCards+", final score: "+ userScore);
        System.out.println("Computer's final hand: "+computerCards+", final score: "+computerScore);
        System.out.println(compareScore(userScore, computerScore));

        Scanner scanUserInput = new Scanner(System.in);
        System.out.print("Do you want to play a game of Blackjack? Type 'y' or 'n': ");
        String userInput = scanUserInput.nextLine();
        if(userInput.equalsIgnoreCase("y")){
            new BlackJack().playGame();
        }
    }

    /**
     *
     * @param score
     * @param compScore
     * @return String message of Lose or Win
     */
    private String compareScore(int score, int compScore){
        if(score == compScore){
            return "Draw 😨";
        }else if(compScore == 0){
            return "Lose, computer has Blackjack 😰";
        }else if(score == 0){
            return "Win with a Blackjack 😎";
        }else if(score > 21){
            return "You went over. You lose 😭";
        }else if(compScore > 21){
            return "Computer went over. You win 🤣";
        }else if(score > compScore){
            return "You Win 😁";
        }else
            return "You lose 😒";
    }

    /**
     *
     * @param cards<Integer></Integer>cards
     * @return sum of @param cards
     */
    private int calculateScore(List<Integer> cards){
        int sum =cards.stream()
                .mapToInt(Integer::intValue)
                .sum();
        if(sum == 21 && cards.size() == 2){
            return 0;
        }
        for(Integer i: cards){
            if(i == 11 && sum > 21){
                cards.remove(i);
                cards.add(1);
            }
        }
        return sum;
    }

    /**
     *
     * @return random int value from cards array
     */
    private int dealCards(){
        Random random = new Random();
        int randomIndex = random.nextInt(13);
        return cards[randomIndex];
    }

}
