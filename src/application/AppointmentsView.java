// AppointmentsView.java
package application;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import java.awt.Button;
import java.util.List;

public class AppointmentsView extends VBox {
	private Scheduler scheduler;

    public AppointmentsView(List<Appointment> appointments) {
        super();
        setupUI(appointments);
        Button backButton = new Button("Go Back");
        backButton.setOnAction(e -> goBack());
        
        // Add appointments data if needed
        
        getChildren().add(backButton);
    }

    private void setupUI(List<Appointment> appointments) {
        // Create and add UI components to display appointments
        for (Appointment appointment : appointments) {
            Label label = new Label(appointment.getTitle());
            getChildren().add(label);
        }
    }
    
    private void goBack() {
        SchedulerView schedulerView = new SchedulerView(scheduler/* Pass scheduler instance if needed */);
        Main.getPrimaryStage().setScene(new Scene(schedulerView, 800, 600));
    }
}
