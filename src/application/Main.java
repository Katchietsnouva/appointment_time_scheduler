// Main.java
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage primaryStage; // Reference to the primary stage

    @Override
    public void start(Stage primaryStage) {
        try {
            Main.primaryStage = primaryStage; // Set the reference to the primary stage
            Scheduler scheduler = new Scheduler();
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            // Create and set up the login view
            LoginView loginView = new LoginView(scheduler);
            loginView.setMainApp(this);
            root.setCenter(loginView);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Appointment Scheduler");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Getter for the primary stage
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}




