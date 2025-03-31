
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * The DeckOfCards class represents a full deck of 52 standard playing cards.
 * It allows shuffling and dealing cards one at a time.
 */
public class DeckOfCards {

    private static final int NUMBER_OF_CARDS = 52; // total cards in a deck
    private static final int CARDS_IN_SUIT = 13;   // cards per suit

    private static final SecureRandom random = new SecureRandom();

    private final ArrayList<Card> deck; // the deck of cards
    private int currentCardIndex;       // index of next card to deal

    /**
     * Constructs a new shuffled deck of 52 cards.
     */
    public DeckOfCards() {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        deck = new ArrayList<Card>();
        currentCardIndex = 0;

        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            String face = faces[i % CARDS_IN_SUIT];
            String suit = suits[i / CARDS_IN_SUIT];
            deck.add(new Card(face, suit));
        }
    }

    /**
     * Shuffles the deck using a simple swap-based algorithm.
     */
    public void shuffle() {
        currentCardIndex = 0;

        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(NUMBER_OF_CARDS);

            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    /**
     * Deals the next card in the deck.
     *
     * @return the next card, or null if no cards remain
     */
    public Card dealCard() {
        if (currentCardIndex < deck.size()) {
            return deck.get(currentCardIndex++);
        } else {
            return null;
        }
    }

    /**
     * Returns true if there are still cards left to deal.
     *
     * @return true if cards remain; false otherwise
     */
    public boolean hasCards() {
        return currentCardIndex < deck.size();
    }

    /**
     * Returns true if the deck is empty (no cards at all).
     *
     * @return true if the deck has no cards
     */
    public boolean isEmpty() {
        return deck.isEmpty();
    }
}
