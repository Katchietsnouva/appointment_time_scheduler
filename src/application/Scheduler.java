// Scheduler.java
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Scheduler extends Application {

    // Data structures for managing appointments and users
    private List<Appointment> appointments;
    private List<User> users;

    // Constructor
    public Scheduler() {
        appointments = new ArrayList<>();
        users = new ArrayList<>();
    }

    // JavaFX start method
    @Override
    public void start(Stage primaryStage) {
        try {
            // Create a label for demonstration
            Label label = new Label("Welcome to Appointment Scheduler!");

            // Create a stack pane to hold the label
            StackPane root = new StackPane();
            root.getChildren().add(label);

            // Set up the scene
            Scene scene = new Scene(root, 400, 400);

            // Set the scene and show the stage
            primaryStage.setScene(scene);
            primaryStage.setTitle("Appointment Scheduler");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Methods for managing appointments
    // Implement methods to add, edit, delete, and retrieve appointments

    // Method to add a new appointment
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Method to edit an existing appointment
    public void editAppointment(int id, Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getId() == id) {
                appointments.set(i, updatedAppointment);
                break;
            }
        }
    }

    // Method to delete an appointment
    public void deleteAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
    }

    // Method to retrieve all appointments
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    // Method to retrieve an appointment by ID
    public Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null; // Return null if appointment with specified ID is not found
    }

    // Methods for managing users
    // Implement methods to add, edit, delete, and retrieve users

    // Method to add a new user
    public void addUser(User user) {
        users.add(user);
    }

    // Method to edit an existing user
    public void editUser(int id, User updatedUser) {
        for
        (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, updatedUser);
                break;
            }
        }
    }

    // Method to delete a user
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    // Method to retrieve all users
    public List<User> getAllUsers() {
        return users;
    }

    // Method to retrieve a user by ID
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // Return null if user with specified ID is not found
    }
}
