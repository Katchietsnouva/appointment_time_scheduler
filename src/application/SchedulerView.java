// SchedulerView.java
package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.TextField;



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

        // Labels for appointment input fields
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
            // Get data from input fields
            String title = appointmentTitleField.getText();
            String date = appointmentDateField.getText();
            String time = appointmentTimeField.getText();
//            String dateTime = date + " " + time;
            String location = appointmentLocationField.getText();
            String description = appointmentDescriptionField.getText();

            // Create a new appointment
            Appointment newAppointment = new Appointment(0, title, LocalDate.parse(date), LocalTime.parse(time),  location, description);
//            Appointment newAppointment = new Appointment(0, title, LocalDateTime.parse(dateTime), location, description);
            
            // Add the new appointment to the scheduler
            scheduler.addAppointment(newAppointment);
            
            // Refresh the view to display the new appointment
            showAppointments(); // You might need to replace this with a more efficient refresh method
        });

        // Labels for user input fields
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();
        Label fullNameLabel = new Label("Full Name:");
        TextField fullNameField = new TextField();

        Button addUserButton = new Button("Add User");
        addUserButton.setOnAction(e -> {
            // Get data from input fields
            String username = usernameField.getText();
            String password = passwordField.getText();
            String fullName = fullNameField.getText();

            // Create a new user
            User newUser = new User(0, username, password, fullName);

            // Add the new user to the scheduler
            scheduler.addUser(newUser);

            // Refresh the view to display the new user
            showUsers(); // You might need to replace this with a more efficient refresh method
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
        // Create and display the AppointmentsView
        AppointmentsView appointmentsView = new AppointmentsView(scheduler.getAllAppointments());
        Main.getPrimaryStage().setScene(new Scene(appointmentsView, 800, 600));
    }

    private void showUsers() {
        // Create and display the UsersView
        UsersView usersView = new UsersView(scheduler.getAllUsers());
        Main.getPrimaryStage().setScene(new Scene(usersView, 800, 600));
    }

    private void logout() {
        // Redirect to the login view
        LoginView loginView = new LoginView(scheduler);
        Main.getPrimaryStage().getScene().setRoot(loginView);
    }
}


