package Controller;

import Database.Database;
import Model.SceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button portfolioButton;

    @FXML
    private Button tradeButton;

    @FXML
    private Button dataButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Text hello;

    @FXML
    void initialize() {
        try {
            hello.setText("Hello " + Database.getName(LoginController.getIndex()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        portfolioButton.setOnAction(event -> new SceneController(anchorPane).activate("Portfolio"));
        tradeButton.setOnAction(event -> {
            new SceneController(anchorPane).activate("Trade");
        });
        dataButton.setOnAction(event -> new SceneController(anchorPane).activate("Data"));
        logoutButton.setOnAction(event -> System.exit(0));
    }

}
