// UsersView.java
package application;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.List;

public class UsersView extends VBox {

    public UsersView(List<User> users) {
        super();
        setupUI(users);
    }

    private void setupUI(List<User> users) {
        // Create and add UI components to display users
        for (User user : users) {
            Label label = new Label(user.getUsername());
            getChildren().add(label);
        }
    }
}


//package application;
//
//public class UsersView {
//    // Fields
//    private int id;
//    private String username;
//    private String password;
//    private String fullName;
//
//    // Constructor
//    public UsersView(int id, String username, String password, String fullName) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.fullName = fullName;
//    }
//
//    // Getters and setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//    
//    // Other methods
//    // Implement additional methods as needed for user management
//}
//
//
//
//
