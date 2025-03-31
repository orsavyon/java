
import java.util.ArrayList;
import java.util.Collection;

/**
 * The Player class represents a player in the card game.
 * Each player has a name and a hand of cards they can play.
 */
public class Player {

    private final String name;              // the name of the player
    private final ArrayList<Card> hand;     // the cards in the player's hand

    /**
     * Constructs a player with the given name.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    /**
     * Returns the name of the player.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a single card to the player's hand.
     *
     * @param card the card to add
     */
    public void addCard(Card card) {
        hand.add(card);
    }

    /**
     * Adds multiple cards to the player's hand.
     *
     * @param cards the collection of cards to add
     */
    public void addCards(Collection<Card> cards) {
        hand.addAll(cards);
    }

    /**
     * Plays (removes and returns) the top card from the player's hand.
     *
     * @return the top card, or null if the hand is empty
     */
    public Card playCard() {
        if (hand.isEmpty()) {
            return null;
        }
        return hand.remove(0);
    }

    /**
     * Checks if the player still has cards in hand.
     *
     * @return true if the player has cards; false otherwise
     */
    public boolean hasCards() {
        return !hand.isEmpty();
    }

    /**
     * Returns the number of cards currently in the player's hand.
     *
     * @return the number of cards in hand
     */
    public int cardCount() {
        return hand.size();
    }
}
