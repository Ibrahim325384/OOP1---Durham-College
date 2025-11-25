
// Title: Blackjack
// Name: Ibrahim Khan
// Date: Jan 25 2025
// Purpose: Console blackjack game
// A FIXED AND BETTER VERSION CAN BE FOUND IN WEEK 7
public class Main {
    private static void PlayBlackJack(){
        final int BUST = 22;
        final int DEALER_HOLD = 16;
        final int PLAYER_WIN = 1;
        final int DEALER_WIN = 2;
        final int NOBODY_WINS = 3;
        int winner = 0;
        final String[] NAMES = {"Nobody", "Player", "Dealer", "Nobody"};

        // Deal and show the dealers hand
        Hand dealerHand = new Hand(2);
        // Hides one of the dealers card
        dealerHand.hideCard(0);
        System.out.println("Dealer: " + dealerHand.toString());

        // Players hand
        Hand playerHand = new Hand(2);
        System.out.println("Player: " + playerHand.toString());

        // Allow player to complete hand
        char draw = 'Y';
        while (playerHand.GetBlackJackValue() < BUST && (draw == 'Y' || draw == 'y')){
            draw = Validation.GetValidCharacter("Do you want another card (Y/N) ");
            if (draw == 'Y' || draw == 'y'){
                playerHand.addRandom(1);
                System.out.println("Player: " + playerHand.toString());
            }
        }
        // Complete dealer hand
        dealerHand.revealHand(0);
        while (dealerHand.GetBlackJackValue() < DEALER_HOLD){
            dealerHand.addRandom(1);
        }
        System.out.println("Dealer: " + dealerHand.toString());

        // Determine the winner
        if (playerHand.GetBlackJackValue() < BUST){
            if (dealerHand.GetBlackJackValue() >= BUST ||
                    < dealerHand.GetBlackJackValue() < playerHand.GetBlackJackValue()){
                winner = PLAYER_WIN;
            }

        } else if (dealerHand.GetBlackJackValue() < BUST) {
            winner = DEALER_WIN;
        }
        else {
            winner = DEALER_WIN;
        }

        System.out.println("Winner: " + NAMES[winner]);
    }
    }
    
    public static void main(String[] args) {
        boolean keepPlaying = true;
        System.out.println("Welcome to BlackJack");
        System.out.println("*******************");
        System.out.println("Insert further description");
        while (keepPlaying == true){
            PlayBlackJack()
            char response = Validation.GetValidCharacter("Do you want to play again (Y/N)?");
            if (response == "N" || response = "n"){
                keepPlaying = false;
            }
        }

}