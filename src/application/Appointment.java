// Appointment.java
package application;

//import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    // Fields
    private int id;
    private String title;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private String description;

    // Constructor
    public Appointment(int id, String title, LocalDate date, LocalTime time, String location, String description) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
