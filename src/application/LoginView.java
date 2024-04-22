// LoginView.java
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {
    private Main mainApp;
    private Scheduler scheduler;

    public LoginView(Scheduler scheduler) {
        super();
        this.scheduler = scheduler;
        setupUI();
    }

    private void setupUI() {
        setSpacing(20);
        setPadding(new Insets(50));
        setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Appointment Scheduler");
        titleLabel.getStyleClass().add("title");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            // Implement authentication logic here
            if (authenticate(username, password)) {
                // If authentication succeeds, show the scheduler view
                SchedulerView schedulerView = new SchedulerView(scheduler);
                Main.getPrimaryStage().getScene().setRoot(schedulerView);
            } else {
                // If authentication fails, display an error message
                // You can implement this part
            }
        });

        getChildren().addAll(titleLabel, grid, loginButton);
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    private boolean authenticate(String username, String password) {
        // Implement authentication logic here
        return true; // Dummy implementation for demonstration
    }
}
