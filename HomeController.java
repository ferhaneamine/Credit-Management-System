package code;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    // Admin section
    @FXML
    private Label adminLabel;  // Matches fx:id in FXML

    // User data
    private int currentUserId;
    private String currentUsername;

    // Dashboard components
    @FXML private Label totalCreancesLabel;
    @FXML private Label paidAmountLabel;
    @FXML private Label pendingInvoicesLabel;
    @FXML private Label pendingAmountLabel;
    @FXML private Label lateInvoicesLabel;
    @FXML private Label lateAmountLabel;
    @FXML private Label creancesPercentage;
    @FXML private Label paidPercentage;

    // Table components
    @FXML private TableView<?> invoicesTable;
    @FXML private TableColumn<?, ?> refColumn;
    @FXML private TableColumn<?, ?> clientColumn;  // Changed from supplierColumn
    @FXML private TableColumn<?, ?> dueDateColumn;
    @FXML private TableColumn<?, ?> amountColumn;
    @FXML private TableColumn<?, ?> statusColumn;

    // Navigation buttons
    @FXML private Button dashboardBtn;
    @FXML private Button clientsBtn;
    @FXML private Button invoicesBtn;
    @FXML private Button paymentsBtn;

    @FXML
    private void initialize() {
        // Initialize table columns if needed
        configureTableColumns();

        // Set default admin label if needed
        if (adminLabel != null) {
            adminLabel.setText("Administrateur");
        } else {
            System.err.println("Warning: adminLabel is null!");
        }
    }

    public void setUserData(int userId, String username, String role) {
        this.currentUserId = userId;
        this.currentUsername = username;

        // Set admin label text
        if (adminLabel != null) {
            adminLabel.setText(role);
        }

        // Load dashboard data
        loadDashboardData();
    }

    private void loadDashboardData() {
        // TODO: Replace with actual data loading
        if (totalCreancesLabel != null) totalCreancesLabel.setText("34 881 DA");
        if (paidAmountLabel != null) paidAmountLabel.setText("15 701 DA");
        if (pendingInvoicesLabel != null) pendingInvoicesLabel.setText("4 Factures");
        if (pendingAmountLabel != null) pendingAmountLabel.setText("25 681 DA");
        if (lateInvoicesLabel != null) lateInvoicesLabel.setText("2 Factures");
        if (lateAmountLabel != null) lateAmountLabel.setText("11 200 Da");
        if (creancesPercentage != null) creancesPercentage.setText("12% depuis le mois dernier");
        if (paidPercentage != null) paidPercentage.setText("8% depuis le mois dernier");
    }

    private void configureTableColumns() {
        // Configure cell value factories
        // Example:
        // refColumn.setCellValueFactory(new PropertyValueFactory<>("reference"));
    }

    @FXML
    private void handleLogout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) adminLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erreur", "Impossible de se déconnecter");
        }
    }

    @FXML
    private void showDashboard() {
        loadDashboardData();
    }

    @FXML
    private void showClientsView() {
        // TODO: Implement clients view
        showAlert("Information", "Affichage des clients");
    }

    @FXML
    private void showInvoicesView() {
        // TODO: Implement invoices view
        showAlert("Information", "Affichage des factures");
    }

    @FXML
    private void showPaymentsView() {
        // TODO: Implement payments view
        showAlert("Information", "Affichage des paiements");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}