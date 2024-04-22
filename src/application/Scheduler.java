// Scheduler.java
package application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Appointment> appointments;
    private List<User> users;
    private ObjectMapper objectMapper;

    public Scheduler() {
        appointments = new ArrayList<>();
        users = new ArrayList<>();
        objectMapper = new ObjectMapper();
    }

    public void saveAppointmentsToJson(List<Appointment> appointments, String filename) {
        try {
            objectMapper.writeValue(new File(filename), appointments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Appointment> loadAppointmentsFromJson(String filename) {
        try {
            return objectMapper.readValue(new File(filename), new TypeReference<List<Appointment>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void editAppointment(int id, Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getId() == id) {
                appointments.set(i, updatedAppointment);
                break;
            }
        }
    }

    public void deleteAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void editUser(int id, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, updatedUser);
                break;
            }
        }
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
