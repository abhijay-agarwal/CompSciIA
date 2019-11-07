package Controller;

import Animation.AlertBox;
import Database.Database;
import Model.SceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SignUpController {

    private final String email_regex = "^(.+)@(.+)$";
    private final String pass_regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,}$";

    private boolean found = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private Button signupButton;

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    @FXML
    void initialize() {
        signupButton.setOnAction(event -> {
            try {
                ArrayList<String> emails = Database.getEmails();
                for (String string : emails) {
                    if (email.getText().equals(string)) {
                        new AlertBox("Error", "This email already exists");
                        clearFields();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    if (!email.getText().matches(email_regex)) {
                        new AlertBox("Email Error", "Your email must ...");
                        clearFields();
                    }
                    if (!password.getText().matches(pass_regex)) {
                        new AlertBox("Password Error", "Your password must be at least 5 characters long and must contain at least one letter and one number");
                        password.setText("");
                        password.positionCaret(0);
                    }
                    if (email.getText().matches(email_regex) && password.getText().matches(pass_regex)) {
                        Database.addName(firstName.getText() + " " + lastName.getText());
                        Database.addEmail(email.getText());
                        Database.addPassword(password.getText());
                        Database.fillInfo();
                        LoginController.setIndex(Database.getEmails().size() - 1);
                        new SceneController(anchorPane).activate("Home");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void clearFields() {
        email.setText("");
        email.positionCaret(0);
        password.setText("");
        password.positionCaret(0);
    }

}
