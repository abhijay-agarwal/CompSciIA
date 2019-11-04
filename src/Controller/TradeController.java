package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TradeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ComboBox<String> stock;

    @FXML
    private TextField quantity;

    @FXML
    private TextField price;

    @FXML
    void initialize() {
        stock.getItems().removeAll(stock.getItems());
        stock.getItems().addAll("AAPL | Apple Inc.", "AMZN | Amazon.com Inc.", "FB | Facebook Inc.", "NFLX | Netflix Inc.", "TSLA | Tesla Inc.", "GOOG | Alphabet Inc.");
    }

}
