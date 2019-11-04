package Controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Animation.Shaker;
import Database.Database;
import Model.AlertBox;
import Model.SceneController;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class LoginController {

    private static int index;
    private boolean found = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Button createButton;

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        LoginController.index = index;
    }


    @FXML
    void initialize() {
//        email.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
//            Paint grey = Paint.valueOf("EBEBEB");
//            Paint green = Paint.valueOf("5BC793");
//            Paint white = Paint.valueOf("FFFFFF");
//            password.setStyle("-fx-control-inner-background: #" + grey.toString().substring(2));
//            password.setStyle("-fx-border-color: " + green.toString().substring(2));
//            password.setStyle("-fx-border-width: 40");
//        });
//
//        password.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
//            Paint paint = Paint.valueOf("EBEBEB");
//            email.setStyle("-fx-control-inner-background: #" + paint.toString().substring(2));
//        });

        loginButton.setOnAction(event -> {
            try {
                index = 0;
                ArrayList<String> emails = Database.getEmails();
                ArrayList<String> passwords = Database.getPasswords();
                for (String string : emails) {
                    if (email.getText().equals(string)) {
                        found = true;
                        break;
                    }
                    index++;
                }
                if (!found) {
                    AlertBox.display("Error", "email doesn't exist");
                    Shaker shaker = new Shaker(email);
                    shaker.shake();
                    email.setText("");
                    email.positionCaret(0);
                    password.setText("");
                    password.positionCaret(0);
                } else {
                    if (password.getText().equals(passwords.get(index))) {
                        new SceneController(anchorPane).activate("Home");
                    } else {
                        Shaker shaker = new Shaker(password);
                        shaker.shake();
                        password.setText("");
                        password.positionCaret(0);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        createButton.setOnAction(event -> new SceneController(anchorPane).activate("SignUp"));

    }

}