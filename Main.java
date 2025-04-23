package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Verify resource loading
            System.out.println("FXML Path: " + getClass().getResource("/views/login.fxml"));

            Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
            Scene scene = new Scene(root);

            // Apply CSS if needed
            // scene.getStylesheets().add(getClass().getResource("/styles/main.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestion des Créances");
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Failed to start application:");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        // Add JVM options programmatically
        launch(args);
    }
}