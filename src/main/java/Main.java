import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Packet Routing Simulation");

        BorderPane root = new BorderPane();
        // Create a main scene
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Call method to set up the GUI
        UIBuilder.setupUI(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
