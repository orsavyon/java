
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Q2 is the main class for launching the JavaFX application.
 * It loads the FXML layout and displays the canvas-based grid drawing tool.
 */
public class Q2 extends Application {

    /**
     * Starts the JavaFX application by loading the FXML layout and displaying the main stage.
     *
     * @param stage the main window of the application
     * @throws Exception if FXML loading fails
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Q2.fxml"));
        Scene scene = new Scene(root, 420, 420);
        stage.setTitle("Q2 Grid Drawing");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method that launches the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    }
}

