// SchedulerView.java
package application;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SchedulerView extends VBox {
    private Scheduler scheduler;

    public SchedulerView(Scheduler scheduler) {
        super();
        this.scheduler = scheduler;
        setupUI();
    }

    private void setupUI() {
        setPadding(new Insets(10));
        setSpacing(10);

        Label welcomeLabel = new Label("Welcome to Scheduler");
        Button appointmentsButton = new Button("Appointments");
        Button usersButton = new Button("Users");
        Button logoutButton = new Button("Logout");

        appointmentsButton.setOnAction(e -> showAppointments());
        usersButton.setOnAction(e -> showUsers());
        logoutButton.setOnAction(e -> logout());

        Label appointmentTitleLabel = new Label("Title:");
        TextField appointmentTitleField = new TextField();

        Label appointmentDateLabel = new Label("Date:");
        TextField appointmentDateField = new TextField();
        Label appointmentTimeLabel = new Label("Time:");
        TextField appointmentTimeField = new TextField();

        Label appointmentLocationLabel = new Label("Location:");
        TextField appointmentLocationField = new TextField();
        Label appointmentDescriptionLabel = new Label("Description:");
        TextField appointmentDescriptionField = new TextField();

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        appointmentDateField.setText(currentDateTime.format(dateFormatter));
        appointmentTimeField.setText(currentDateTime.format(timeFormatter));

        Button addAppointmentButton = new Button("Add Appointment");
        addAppointmentButton.setOnAction(e -> {
            String title = appointmentTitleField.getText();
            String date = appointmentDateField.getText();
            String time = appointmentTimeField.getText();
            String location = appointmentLocationField.getText();
            String description = appointmentDescriptionField.getText();

            Appointment newAppointment = new Appointment(0, title, LocalDate.parse(date), LocalTime.parse(time), location, description);
            scheduler.addAppointment(newAppointment);

            List<Appointment> appointments = scheduler.getAllAppointments();
            scheduler.saveAppointmentsToJson(appointments, "appointments.json");

            showAlert(Alert.AlertType.INFORMATION, "Success", "Appointment added successfully.");
        });

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();
        Label fullNameLabel = new Label("Full Name:");
        TextField fullNameField = new TextField();

        Button addUserButton = new Button("Add User");
        addUserButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String fullName = fullNameField.getText();

            User newUser = new User(0, username, password, fullName);
            scheduler.addUser(newUser);

            List<User> users = scheduler.getAllUsers();
            // You can implement a similar method to save users to JSON if needed

            showAlert(Alert.AlertType.INFORMATION, "Success", "User added successfully.");
        });

        getChildren().addAll(
            welcomeLabel,
            appointmentsButton,
            usersButton,
            logoutButton,
            appointmentTitleLabel,
            appointmentTitleField,
            appointmentDateLabel,
            appointmentDateField,
            appointmentTimeLabel,
            appointmentTimeField,
            appointmentLocationLabel,
            appointmentLocationField,
            appointmentDescriptionLabel,
            appointmentDescriptionField,
            addAppointmentButton,
            usernameLabel,
            usernameField,
            passwordLabel,
            passwordField,
            fullNameLabel,
            fullNameField,
            addUserButton
        );
    }

    private void showAppointments() {
        AppointmentsView appointmentsView = new AppointmentsView(scheduler.getAllAppointments());
        Main.getPrimaryStage().setScene(new Scene(appointmentsView, 800, 600));
    }

    private void showUsers() {
        UsersView usersView = new UsersView(scheduler.getAllUsers());
        Main.getPrimaryStage().setScene(new Scene(usersView, 800, 600));
    }

    private void logout() {
        LoginView loginView = new LoginView(scheduler);
        Main.getPrimaryStage().getScene().setRoot(loginView);
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
