
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * The WarGame class runs the card game logic in a text-based console version.
 * It supports two players who play cards until one player wins.
 */
public class WarGame {

    private static final int CARDS_FOR_WAR = 3;

    private Player player1;
    private Player player2;
    private DeckOfCards deck;

    /**
     * Constructs a new WarGame with two players and a shuffled deck.
     *
     * @param player1Name the name of the first player
     * @param player2Name the name of the second player
     */
    public WarGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        deck = new DeckOfCards();
        deck.shuffle();
        dealCards();
    }

    /**
     * Deals cards to both players from the shuffled deck.
     */
    private void dealCards() {
        while (!deck.isEmpty()) {
            player1.addCard(deck.dealCard());
            if (!deck.isEmpty()) {
                player2.addCard(deck.dealCard());
            }
        }
    }

    /**
     * Plays the game until one player runs out of cards.
     */
    public void playGame() {
        while (player1.hasCards() && player2.hasCards()) {
            playRound();
        }
        declareWinner();
    }

    /**
     * Plays one round of the game, including handling of war if needed.
     */
    private void playRound() {
        if (!player1.hasCards() || !player2.hasCards()) {
            return;
        }

        Card card1 = player1.playCard();
        Card card2 = player2.playCard();

        System.out.println(player1.getName() + " plays: " + card1);
        System.out.println(player2.getName() + " plays: " + card2);

        Queue<Card> warPile = new LinkedList<Card>();
        warPile.add(card1);
        warPile.add(card2);

        if (card1.compareTo(card2) > 0) {
            System.out.println(player1.getName() + " wins the round!");
            player1.addCards(warPile);
        } else if (card1.compareTo(card2) < 0) {
            System.out.println(player2.getName() + " wins the round!");
            player2.addCards(warPile);
        } else {
            System.out.println("War!");

            if (player1.cardCount() < CARDS_FOR_WAR || player2.cardCount() < CARDS_FOR_WAR) {
                System.out.println("A player doesn't have enough cards for war. The game ends.");
                return;
            }

            ArrayList<Card> warCards1 = new ArrayList<Card>();
            ArrayList<Card> warCards2 = new ArrayList<Card>();

            for (int i = 0; i < CARDS_FOR_WAR; i++) {
                warCards1.add(player1.playCard());
                warCards2.add(player2.playCard());
            }

            Card warCard1 = player1.playCard();
            Card warCard2 = player2.playCard();

            warPile.addAll(warCards1);
            warPile.addAll(warCards2);
            warPile.add(warCard1);
            warPile.add(warCard2);

            System.out.println(player1.getName() + " plays war card: " + warCard1);
            System.out.println(player2.getName() + " plays war card: " + warCard2);

            if (warCard1.compareTo(warCard2) > 0) {
                System.out.println(player1.getName() + " wins the war!");
                player1.addCards(warPile);
            } else if (warCard1.compareTo(warCard2) < 0) {
                System.out.println(player2.getName() + " wins the war!");
                player2.addCards(warPile);
            } else {
                System.out.println("Another tie! Continuing war...");
                playRound(); // recursive war
            }
        }
    }

    /**
     * Declares the winner based on who still has cards.
     */
    private void declareWinner() {
        if (!player1.hasCards()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println(player1.getName() + " wins the game!");
        }
    }

    /**
     * The main method to start a console-based War game.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        String player2Name = scanner.nextLine();

        WarGame game = new WarGame(player1Name, player2Name);
        game.playGame();
    }
}
