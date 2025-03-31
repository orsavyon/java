
/**
 * The Card class represents a playing card with a face and a suit.
 * Each card has a numeric value used for comparison (Ace = 14 down to Deuce = 2).
 */
public class Card implements Comparable<Card> {

    private static final int VALUE_ACE = 14;
    private static final int VALUE_KING = 13;
    private static final int VALUE_QUEEN = 12;
    private static final int VALUE_JACK = 11;
    private static final int VALUE_TEN = 10;
    private static final int VALUE_NINE = 9;
    private static final int VALUE_EIGHT = 8;
    private static final int VALUE_SEVEN = 7;
    private static final int VALUE_SIX = 6;
    private static final int VALUE_FIVE = 5;
    private static final int VALUE_FOUR = 4;
    private static final int VALUE_THREE = 3;
    private static final int VALUE_DEUCE = 2;

    private final String face; // e.g., "King", "Seven"
    private final String suit; // e.g., "Hearts", "Clubs"
    private final int value;   // numeric value for comparison

    /**
     * Constructs a Card with a given face and suit.
     *
     * @param cardFace the face of the card
     * @param cardSuit the suit of the card
     * @throws IllegalArgumentException if the face is invalid
     */
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace;
        this.suit = cardSuit;
        this.value = determineValue(cardFace);
    }

    /**
     * Returns the string representation of the card.
     *
     * @return card as "Face of Suit"
     */
    public String toString() {
        return face + " of " + suit;
    }

    /**
     * Compares this card with another card based on value.
     *
     * @param other the other card to compare to
     * @return difference in value
     */
    public int compareTo(Card other) {
        return this.value - other.value;
    }

    /**
     * Returns the numeric value of the card.
     *
     * @return value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * Determines numeric value based on the card face.
     *
     * @param face the face of the card
     * @return the corresponding numeric value
     * @throws IllegalArgumentException if face is not recognized
     */
    private int determineValue(String face) {
        if (face.equals("Ace")) {
            return VALUE_ACE;
        } else if (face.equals("King")) {
            return VALUE_KING;
        } else if (face.equals("Queen")) {
            return VALUE_QUEEN;
        } else if (face.equals("Jack")) {
            return VALUE_JACK;
        } else if (face.equals("Ten")) {
            return VALUE_TEN;
        } else if (face.equals("Nine")) {
            return VALUE_NINE;
        } else if (face.equals("Eight")) {
            return VALUE_EIGHT;
        } else if (face.equals("Seven")) {
            return VALUE_SEVEN;
        } else if (face.equals("Six")) {
            return VALUE_SIX;
        } else if (face.equals("Five")) {
            return VALUE_FIVE;
        } else if (face.equals("Four")) {
            return VALUE_FOUR;
        } else if (face.equals("Three")) {
            return VALUE_THREE;
        } else if (face.equals("Deuce")) {
            return VALUE_DEUCE;
        } else {
            throw new IllegalArgumentException("Invalid card face: " + face);
        }
    }
}
