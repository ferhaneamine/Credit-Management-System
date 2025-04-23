package code;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please fill in all fields");
            return;
        }

        int userId = registerAccount.login(username, password);

        if (userId != -1) {
            try {
                URL fxmlLocation = getClass().getResource("/views/Home.fxml");
                if (fxmlLocation == null) {
                    throw new IOException("FXML file not found at /views/Home.fxml");
                }

                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Parent root = loader.load();

                HomeController homeController = loader.getController();
                // Get actual role from your authentication system or use default
                String userRole = getRoleForUser(userId); // Implement this method
                homeController.setUserData(userId, username, userRole);

                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setMaximized(true);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to load home screen: " + e.getMessage());
            }
        } else {
            showAlert("Login Failed", "Invalid credentials");
        }
    }

    // Example method to get user role
    private String getRoleForUser(int userId) {
        // Implement your logic to get user role from database
        return "Administrateur"; // Default or fetched from DB
    }
    @FXML
    private void handleRegister() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please fill all fields");
            return;
        }

        if (registerAccount.register(username, password)) {
            showAlert("Success", "Account created successfully!");
        } else {
            showAlert("Error", "Username already exists");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);  // Changed to ERROR type
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}