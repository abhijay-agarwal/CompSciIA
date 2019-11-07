import Database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        int[] array = Database.getStocks(0);
        array[1] = 23;
        Database.changeLine("/Users/agarw9646/IdeaProjects/Comp Sci IA/src/Database/stocks", Arrays.toString(array).replaceAll("[\\[\\],]", ""), 0);

        System.out.println(Arrays.toString(Database.getStocks(0)).replaceAll("[\\[\\],]", ""));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
