
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The GameController class manages the gameplay and user interaction.
 * It handles player turns, comparisons, wars, and shows game progress via dialog boxes.
 */
public class GameController {

    @FXML private Label player1CardLabel; // displays player 1's card
    @FXML private Label player2CardLabel; // displays player 2's card
    @FXML private Button playTurnButton;  // the button to play a turn

    private Player player1;
    private Player player2;
    private Queue<Card> warPile;

    /**
     * Initializes the game controller and starts a new game.
     */
    public void initialize() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        warPile = new LinkedList<Card>();

        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        // Deal cards to both players alternately
        while (deck.hasCards()) {
            player1.addCard(deck.dealCard());
            if (deck.hasCards()) {
                player2.addCard(deck.dealCard());
            }
        }
    }

    /**
     * Handles the logic when the user clicks the "Play Turn" button.
     */
    @FXML
    public void playTurn() {
        if (!player1.hasCards() || !player2.hasCards()) {
            showDialog("Game Over", getWinnerName() + " wins the game!");
            playTurnButton.setDisable(true);
            return;
        }

        Card card1 = player1.playCard();
        Card card2 = player2.playCard();

        player1CardLabel.setText(card1.toString());
        player2CardLabel.setText(card2.toString());

        warPile.clear();
        warPile.add(card1);
        warPile.add(card2);

        String roundSummary = player1.getName() + " played: " + card1 + "\n" +
                player2.getName() + " played: " + card2 + "\n";

        if (card1.getValue() > card2.getValue()) {
            player1.addCards(warPile);
            roundSummary += player1.getName() + " wins the round!";
        } else if (card2.getValue() > card1.getValue()) {
            player2.addCards(warPile);
            roundSummary += player2.getName() + " wins the round!";
        } else {
            roundSummary += "It's a tie! Starting a war...";
            showDialog("War", roundSummary);
            handleWar();
            return;
        }

        showDialog("Round Result", roundSummary);
    }

    /**
     * Handles the logic for a war (when both cards are equal in value).
     */
    /**
     * Handles the "war" situation when two players draw equal-value cards.
     * Each player places 3 face-down cards and then a fourth face-up card.
     * The winner of the war takes all cards played. If it's another tie,
     * the war continues recursively until a winner is determined.
     */
    private void handleWar() {
        final int CARDS_FOR_WAR = 3;

        // Check if both players have enough cards to continue the war
        if (player1.cardCount() < CARDS_FOR_WAR || player2.cardCount() < CARDS_FOR_WAR) {
            showDialog("War Ended", "A player doesn't have enough cards for war.\n" + getWinnerName() + " wins the game!");
            playTurnButton.setDisable(true);
            return;
        }

        // Temporary lists to hold the 3 face-down cards each player places
        ArrayList<Card> warCards1 = new ArrayList<Card>();
        ArrayList<Card> warCards2 = new ArrayList<Card>();

        // Each player plays 3 face-down cards
        for (int i = 0; i < CARDS_FOR_WAR; i++) {
            warCards1.add(player1.playCard());
            warCards2.add(player2.playCard());
        }

        // Each player plays 1 face-up card to determine the winner of the war
        Card warCard1 = player1.playCard();
        Card warCard2 = player2.playCard();

        // Add all played cards to the shared war pile
        warPile.addAll(warCards1);
        warPile.addAll(warCards2);
        warPile.add(warCard1);
        warPile.add(warCard2);

        // Build the summary message of the entire war sequence
        StringBuilder warSummary = new StringBuilder();
        warSummary.append("War begins!\n");

        warSummary.append(player1.getName() + " places: ");
        for (Card c : warCards1) {
            warSummary.append(c + ", ");
        }

        warSummary.append("\n" + player2.getName() + " places: ");
        for (Card c : warCards2) {
            warSummary.append(c + ", ");
        }

        warSummary.append("\nWar card for " + player1.getName() + ": " + warCard1);
        warSummary.append("\nWar card for " + player2.getName() + ": " + warCard2);

        // Determine the winner of the war
        if (warCard1.getValue() > warCard2.getValue()) {
            player1.addCards(warPile);
            warSummary.append("\n" + player1.getName() + " wins the war and takes all cards!");
        } else if (warCard2.getValue() > warCard1.getValue()) {
            player2.addCards(warPile);
            warSummary.append("\n" + player2.getName() + " wins the war and takes all cards!");
        } else {
            warSummary.append("\nAnother tie! War continues...");
            showDialog("War Continues", warSummary.toString());
            handleWar(); // Recursive call for additional war
            return;
        }

        // Show the final war result
        showDialog("War Result", warSummary.toString());
        warPile.clear(); // Clear the pile for the next round
    }


    /**
     * Displays an alert dialog with the given title and message.
     *
     * @param title the title of the dialog
     * @param message the message to display
     */
    private void showDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Returns the name of the player who still has cards.
     *
     * @return the name of the winning player
     */
    private String getWinnerName() {
        return player1.hasCards() ? player1.getName() : player2.getName();
    }
}
