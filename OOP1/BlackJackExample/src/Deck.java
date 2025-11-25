import java.util.ArrayList;
import java.util.Collections;

// Title: PlayingCard
// Name: Ibrahim Khan
// Date: Feb 18, 2025
// Purpose: Represents a deck of cards
public class Deck {
    private ArrayList<PlayingCard> cards = new ArrayList<>();
    public Deck(){
        for (int i = 0; i < 14; i++){
            for (int j = 1; j < 5; j++){
                PlayingCard newCard = new PlayingCard(i, j, true);
                cards.add(newCard);
            }
        }
    }
    // Accessor
    public String showDeck(){
        String deck = "";
        for (PlayingCard card : cards){
            deck += card.getStateSymbole() + " ";
        }
        return deck;
    }

    // Mutators
    public void shuffleDeck(){
        Collections.shuffle(cards);
    }
}

