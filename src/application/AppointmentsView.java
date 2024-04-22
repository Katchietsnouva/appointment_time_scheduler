// AppointmentsView.java
package application;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.List;

public class AppointmentsView extends VBox {

    public AppointmentsView(List<Appointment> appointments) {
        super();
        setupUI(appointments);
    }

    private void setupUI(List<Appointment> appointments) {
        // Create and add UI components to display appointments
        for (Appointment appointment : appointments) {
            Label label = new Label(appointment.getTitle());
            getChildren().add(label);
        }
    }
}
