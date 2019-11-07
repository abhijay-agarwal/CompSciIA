package Animation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Class created by Abhi
 */

public class AlertBox {

    public AlertBox(String title, String message) {
        display(title, message);
    }

    private void display(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText("Something went wrong");
        alert.setContentText(message);
        DialogPane dialogPane = alert.getDialogPane();
        try {
            dialogPane.getStylesheets().add(getClass().getResource("/Extra/AlertBox.css").toExternalForm());
            dialogPane.getStyleClass().add("dialog");
        } catch (Exception e) {
            System.out.println("lol this shit don't work");
        }

        alert.showAndWait();
    }

}
