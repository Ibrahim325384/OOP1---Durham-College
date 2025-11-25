// Title: PlayingCard
// Name: Ibrahim Khan
// Date: Feb 18, 2025
// Purpose: Represents a collection of cards

// Importing the arrayList so we can use it
import java.util.ArrayList;

public class Hand {
    // Attributes
    private ArrayList <PlayingCard> cards = new ArrayList<>();

    // Behaviour
    // Constructors
    // Default
    public Hand() {
        // no action
    }
    // Parameterized - iniatilize with a number of existing cards
    public Hand(ArrayList<PlayingCard> cards){
        this.cards = cards;
    }
    // Parameterized - iniatilize with a number of random cards
    public Hand(int numCards){
        addRandom(numCards);
    }
    // Mutators
    // Add a card to the deck
    public void addCard(PlayingCard card){
        cards.add(card);
    }
    // Add a number of cards to the hand
    public void addCards(ArrayList<PlayingCard> newCards){
        for (PlayingCard card : newCards){
            addCard(card);
        }
    }
    // Add a number of random cards to the hand
     public void addRandom(int numCards){
        for (int i = 0; i < numCards; i++){
            PlayingCard card = new PlayingCard();
            addCard(card);
        }
     }
    // Remove a card
    public PlayingCard playCard(){
        return cards.remove(0);
    }
    // Play a specific card
    public PlayingCard playCard(int index){
        if (index < 0 || index >= cards.size()){
            throw new IndexOutOfBoundsException();
        }
        return cards.get(index);
    }
    // Reveal the card in the players hand (make it visible outside the class)
    public void revealHand(){
        for (int i = 0; i < cards.size(); i++){
            cards.get(i).faceUp = true;
        }
    }
    // Reveal a specific card (make it visible outside the class)
    public void revealCard(int index){
        if (index < 0 || index >= cards.size()){
            throw new IndexOutOfBoundsException();
        }
        cards.get(index).faceUp = true;
    }
    // Hide the cards in the players hand (make it not visible outside the class)
    public void hideHand() {
        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).faceUp = false;
        }
    }
    // Hides a specific card (make it visible outside the class)
    public void hideCard(int index){
        if (index < 0 || index >= cards.size()){
            throw new IndexOutOfBoundsException();
        }
        cards.get(index).faceUp = false;
    }
    // Returns the value of the hand
    public int GetBlackJackValue(){
        int retVal = 0;
        int aceCount = 0;
        for (PlayingCard card : cards){
            if (card.getValue() == 1){
                aceCount++;
            }
            retVal += card.getValue();
        }
        while (retVal <12 && aceCount > 0){
            retVal += 10;
            aceCount++;
        }
        return retVal;
    }
    // Accessors
    // Report the state of the hand
    public String toString(){
        String retVal = "";
        for (PlayingCard card : cards){
            retVal += card.getStateSymbole() + " ";
        }
        return retVal;
    }
}
