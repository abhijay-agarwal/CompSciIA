package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TradeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text hello;

    @FXML
    private ComboBox<String> stock;

    @FXML
    void initialize() {
        stock.getItems().removeAll(stock.getItems());
        stock.getItems().addAll( "AAPL | Apple Inc.", "AMZN | Amazon.com Inc.", "FB | Facebook Inc.", "NFLX | Netflix Inc.", "TSLA | Tesla Inc.", "GOOG | Alphabet Inc.");
        stock.setStyle("-fx-font: 20px \"DIN Alternate\";");
        stock.setStyle("-");
    }
}
