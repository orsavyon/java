
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The Main class is the entry point of the JavaFX application.
 * It loads the game UI from FXML and displays the main window.
 */
public class Main extends Application {

    /**
     * Starts the JavaFX application by loading the game layout and setting the scene.
     *
     * @param primaryStage the main application window
     * @throws Exception if the FXML file cannot be loaded
     */
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("War Card Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method launches the JavaFX application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    }
}
