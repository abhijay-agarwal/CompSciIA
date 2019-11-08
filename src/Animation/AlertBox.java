package Animation;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

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
            e.printStackTrace();
        }
        alert.showAndWait();
    }

}
