package Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneController {

    private static final String BASE_PATH = "/view/";

    private Pane pane;
    private HashMap<String, Pane> screenMap = new HashMap<String, Pane>() {{
        try {
            put("Login", FXMLLoader.load(getClass().getResource(BASE_PATH + "Login.fxml")));
            put("SignUp", FXMLLoader.load(getClass().getResource(BASE_PATH + "SignUp.fxml")));
            put("Home", FXMLLoader.load(getClass().getResource(BASE_PATH + "Home.fxml")));
            put("Trade", FXMLLoader.load(getClass().getResource(BASE_PATH + "Trade.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }};

    public SceneController(Pane pane) {
        this.pane = pane;
    }

    public void addScreen(String name) throws IOException {
        screenMap.put(name, FXMLLoader.load(getClass().getResource(BASE_PATH + capitalize(name) + ".fxml")));
    }

    public void removeScreen(String name) {
        screenMap.remove(name);
    }

    public void activate(String name) {
        activate(name, 600, 400);
    }

    public void activate(String name, int width, int height) {
        Pane window = screenMap.get(name);
        pane.getChildren().setAll(window);
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setTitle(capitalize(name));
    }

    public void switchScene(String name) throws IOException {
        Stage oldStage = (Stage) pane.getScene().getWindow();
        oldStage.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(BASE_PATH + name + ".fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(capitalize(name));
        stage.show();
    }

    private static String capitalize(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}