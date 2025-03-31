
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Q2Controller handles the logic behind drawing a matrix-like grid on a canvas.
 * It fills 10% of the cells randomly with black rectangles whenever the user clicks a button.
 */
public class Q2Controller {

    /** The canvas element on which the grid is drawn. */
    @FXML
    private Canvas canv;

    /** The graphics context used to draw on the canvas. */
    private GraphicsContext gc;

    /**
     * Initializes the controller. Called automatically after FXML is loaded.
     * Retrieves the graphics context from the canvas.
     */
    @FXML
    public void initialize() {
        gc = canv.getGraphicsContext2D();
    }

    /**
     * Handles the button press event.
     * Draws a grid of squares with 10-pixel spacing,
     * and randomly fills 10% of them with black color.
     *
     * @param event the ActionEvent triggered by button click
     */
    @FXML
    void drawRectPressed(ActionEvent event) {
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight()); // clear previous drawing

        final int RECT_SIZE = 10; // each square cell is 10x10 pixels
        int rows = (int) (canv.getHeight() / RECT_SIZE); // number of rows
        int cols = (int) (canv.getWidth() / RECT_SIZE);  // number of columns
        int totalCells = rows * cols;

        int numToFill = (int) (totalCells * 0.1); // 10% of the grid will be filled

        Set<String> filledCells = new HashSet<String>(); // store filled cell coordinates
        Random random = new Random();

        // Randomly select cells to fill
        while (filledCells.size() < numToFill) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            filledCells.add(row + "," + col);
        }

        // Draw the full grid and fill selected cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double x = j * RECT_SIZE;
                double y = i * RECT_SIZE;

                gc.setStroke(Color.BLACK); // grid border
                gc.strokeRect(x, y, RECT_SIZE, RECT_SIZE);

                // fill selected cells with black
                if (filledCells.contains(i + "," + j)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(x, y, RECT_SIZE, RECT_SIZE);
                }
            }
        }
    }
}
