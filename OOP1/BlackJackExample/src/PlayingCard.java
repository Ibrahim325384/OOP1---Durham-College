// Title: PlayingCard
// Name: Ibrahim Khan
// Date: Jan 25 2025
// Purpose: Encapsulate characteristics and behaviour of a  playing card
public class PlayingCard {

    Boolean faceUp;
    private int rank; // Valid range is 1 to 13
    private int suit; // Valid range is 1 to 4

    static final int MIN_RANK = 1;
    static final int MAX_RANK = 13;
    static final int MIN_Suit = 1;
    static final int MAX_Suit = 4;
    static String[] rankNames = {"FaceDown", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    static String[] rankChars = {"X", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static String[] suitNames = {"X", "Hearts", "Clubs", "Diamonds", "Spades"};
    static String[] suitChars = {"X", "H", "C", "D", "S"};
    static String[] suitSymbol = {"X", "♠", "♥", "♦", "♣"};
    static int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    // Constructor to set default for it when it is initailized
    PlayingCard() {
        rank =  1 + (int) Math.round(Math.random()*12.0);
        suit = 1 + (int) Math.round(Math.random()*3.0);
        faceUp = true;
    }
    PlayingCard(int newRank, int newSuit, boolean newFaceUp) {
        setRank(newRank);
        setSuit(newSuit);
        faceUp = newFaceUp;
    }

    // Accessor to get a private variable
    public int getRank() {
        return (faceUp)?rank:0;
    }

    public int getValue() {return (faceUp)?rankValues[rank]:rankValues[0]}

    public String getRankString() {
        return (faceUp)?rankNames[rank]:rankNames[0];
    }

    public String getRankShort() {
        return (faceUp)?rankChars[rank]:rankChars[0];
    }

    public int getSuit() {
        return (faceUp)?suit:0;
    }

    public String getSuitString() {
        return (faceUp)?suitNames[suit]:suitNames[0];
    }

    public String getSuitSymbol() {
        return (faceUp)?suitSymbol[suit]:suitSymbol[0];
    }

    public String getRankChar(){
        return (faceUp)?rankChars[rank]:rankChars[0];
    }

    public String getSuitChars(){
        return (faceUp)?suitChars[suit]:suitChars[0];
    }

    public String getSate(){
        String state = "";
        if (faceUp){
            state = getRankString() + " of " + getSuitString();
        }
        else{
            state = "Face Down";
        }
        return state;
    }

    public String getStateShort(){
        String state = "";
        if (faceUp){
            state = getRankChar() + " of " + getSuitChars();
        }
        else{
            state = "XX";
        }
        return state;
    }

    public String getStateSymbole(){
        String state = "";
        if (faceUp){
            state = getRankChar() + " of " + getSuitChars();
        }
        else{
            state = "XX";
        }
        return state;
    }

    // Mutators to change a variabe
    public void setRank(int newRank) {
        if (newRank >= MIN_RANK && newRank <= MAX_RANK) {
            rank = newRank;
        } else {
            // This is for if the user suggests an innapropriate number
            throw new IllegalArgumentException("Invalid Rank");
        }
    }

    public void setSuit(int newSuit) {
        if (newSuit >= MIN_Suit && newSuit <= MAX_Suit) {
            suit = newSuit;
        } else {
            // This is for if the user suggests an innapropriate number
            throw new IllegalArgumentException("Invalid Suit");
        }
    }
    public void flipCard() {faceUp = !faceUp;}
}

