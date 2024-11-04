package com.tartanga.grupo4.controllers;

import com.tartanga.grupo4.model.User;
import exceptions.MaxConnectionsException;
import exceptions.ServerErrorException;
import exceptions.UserExistInDatabaseException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Controller class for the Sign-Up view.
 * <p>
 * This class manages the Sign-Up user interface, handling input validation,
 * user registration, and navigation back to the Sign-In view.
 * The main responsibilities include:
 * <ul>
 *     <li>Validating user inputs to ensure correctness and completeness.</li>
 *     <li>Attempting to register a new user and handling potential errors.</li>
 *     <li>Navigating back to the Sign-In view when requested.</li>
 *     <li>Displaying alerts for user feedback and information.</li>
 * </ul>
 */
public class SignUpController {

    @FXML
    private Button btn_Back, btn_Register;
    @FXML
    private TextField fld_Email, fld_Name, fld_City, fld_Street, fld_Zip;
    @FXML
    private PasswordField fld_Password, fld_Confirm;
    @FXML
    private CheckBox chb_Active;
    @FXML
    private Label lbl_error_Email, lbl_error_Password, lbl_error_Confirm, lbl_error_Name, lbl_error_City, lbl_error_Street, lbl_error_Zip;

    /**
     * Initializes the Sign-Up view.
     * <p>
     * This method is automatically called after the FXML elements have been loaded.
     * It sets up event handlers for the Back and Register buttons.
     */
    @FXML
    private void initialize() {
        btn_Back.setOnAction(this::handleGoBack);
        btn_Register.setOnAction(this::handleRegister);
    }

    /**
     * Handles navigation back to the Sign-In view when the Back button is clicked.
     * <p>
     * Loads the Sign-In view FXML and switches the current stage's scene to it.
     *
     * @param event The action event triggered by clicking the Back button.
     */
    @FXML
    private void handleGoBack(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tartanga/grupo4/views/SignInView.fxml"));
            Parent mainView = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(mainView);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the registration process when the Register button is clicked.
     * <p>
     * This method validates all user inputs for correctness. If any input is invalid,
     * error messages are displayed next to the corresponding fields. If all inputs are
     * valid, an attempt is made to register the user by calling the server API.
     * Appropriate feedback is given based on the outcome of the registration attempt.
     *
     * @param event The action event triggered by clicking the Register button.
     */
    private void handleRegister(ActionEvent event) {
        String email = fld_Email.getText();
        String password = fld_Password.getText();
        String confirm = fld_Confirm.getText();
        String name = fld_Name.getText();
        String city = fld_City.getText();
        String street = fld_Street.getText();
        String zip = fld_Zip.getText();
        boolean isActive = chb_Active.isSelected();
        boolean hasError = false;

        // Validate email
        if (email.isEmpty()) {
            lbl_error_Email.setText("Email is required.");
            hasError = true;
        } else if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            lbl_error_Email.setText("Please enter a valid email address.");
            hasError = true;
        } else {
            lbl_error_Email.setText("");
        }

        // Validate password
        if (password.isEmpty()) {
            lbl_error_Password.setText("Password is required.");
            hasError = true;
        } else if (!password.matches("^.{6,}$")) {
            lbl_error_Password.setText("Password must be at least 6 characters long.");
            hasError = true;
        } else if (!password.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).*")) {
            lbl_error_Password.setText("Password must include at least one uppercase letter, one lowercase letter, and one number.");
            hasError = true;
        } else {
            lbl_error_Password.setText("");
        }

        // Validate password confirmation
        if (confirm.isEmpty()) {
            lbl_error_Confirm.setText("Password confirmation is required.");
            hasError = true;
        } else if (!password.equals(confirm)) {
            lbl_error_Confirm.setText("Passwords don’t match.");
            hasError = true;
        } else {
            lbl_error_Confirm.setText("");
        }

        // Validate name
        if (name.isEmpty()) {
            lbl_error_Name.setText("Name is required.");
            hasError = true;
        } else if (name.matches(".*\\d.*")) {
            lbl_error_Name.setText("Name cannot contain numbers.");
            hasError = true;
        } else {
            lbl_error_Name.setText("");
        }

        // Validate city
        if (city.isEmpty()) {
            lbl_error_City.setText("City is required.");
            hasError = true;
        } else if (city.matches(".*\\d.*")) {
            lbl_error_City.setText("City cannot contain numbers.");
            hasError = true;
        } else {
            lbl_error_City.setText("");
        }

        // Validate street
        if (street.isEmpty()) {
            lbl_error_Street.setText("Street is required.");
            hasError = true;
        } else if (street.matches(".*\\d.*")) {
            lbl_error_Street.setText("Street cannot contain numbers.");
            hasError = true;
        } else {
            lbl_error_Street.setText("");
        }

        // Validate ZIP code
        if (zip.isEmpty()) {
            lbl_error_Zip.setText("ZIP code is required.");
            hasError = true;
        } else if (!zip.matches("\\d{1,10}")) {
            lbl_error_Zip.setText("Invalid ZIP code.");
            hasError = true;
        } else {
            lbl_error_Zip.setText("");
        }

        // Proceed with registration if no errors
        if (!hasError) {
            User user = new User(email, password, name, street, isActive, city, Integer.parseInt(zip));
            try {
                user = ClientFactory.getInstance().getSignable().signUp(user);
                alert("Successful", "User created successfully.", "Go back to sign in to your account.");
                clearFields();
            } catch (UserExistInDatabaseException error) {
                alert("Error", "Login already exists.", "Introduce a different e-mail.");
            } catch (ServerErrorException error) {
                alert("Error", "An error occurred on the server.", "Contact your administrator.");
            } catch (MaxConnectionsException error) {
                alert("Error", "Too many connections simultaneously, please be patient.", "Try to connect later.");
            } catch (IOException error) {
                error.printStackTrace();
            } catch (Exception error) {
                error.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("There was an error in one of the fields.");
            alert.setContentText("Please try again.");
            alert.showAndWait();
        }
    }

    /**
     * Clears all input fields in the Sign-Up form.
     * <p>
     * Resets each TextField, PasswordField, and CheckBox to its default state,
     * clearing any previously entered user data.
     */
    private void clearFields() {
        fld_Email.setText("");
        fld_Password.setText("");
        fld_Confirm.setText("");
        fld_Name.setText("");
        fld_City.setText("");
        fld_Street.setText("");
        fld_Zip.setText("");
        chb_Active.setSelected(false);
    }

    /**
     * Displays an alert dialog with the specified title, header, and content.
     * <p>
     * The alert is a modal dialog that informs the user about the result of an
     * operation (e.g., registration success or failure). The dialog includes
     * a close button to dismiss the alert.
     *
     * @param title   The title of the alert window.
     * @param header  The header text of the alert, providing a brief description.
     * @param content The detailed message to be displayed in the alert.
     */
    private void alert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.getButtonTypes().add(new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE));
        alert.showAndWait();
    }
}
