package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Model.Buy;
import Model.Sell;
import Model.Stock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TradeController {

    public double value;
    public double priceTemp;
    public double quantityTemp;

    public static Buy buyTemp;
    public static Sell sellTemp;

    public static List<Buy> buyQueue = new ArrayList<Buy>();
    public static List<Sell> sellQueue = new ArrayList<Sell>();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Rectangle rectangle;

    @FXML
    private ComboBox<String> stock;

    @FXML
    private TextField quantity;

    @FXML
    private TextField price;

    @FXML
    private Button buy;

    @FXML
    private Button sell;

    @FXML
    private Text current;

    @FXML
    void initialize() {
        stock.getItems().removeAll(stock.getItems());
        stock.getItems().addAll("AAPL | Apple Inc.", "AMZN | Amazon.com, Inc.", "FB | Facebook, Inc.", "NFLX | Netflix, Inc.", "TSLA | Tesla, Inc.", "GOOG | Alphabet Inc.");

        rectangle.addEventHandler(MouseEvent.ANY, event -> {
            if (stock.getValue() != null) {
                current.setText("Current price: " + getStock().getPrice());
            }
        });

        buy.setOnAction(event -> {
            quantityTemp = Integer.parseInt(quantity.getText());
            String priceString = price.getText();

            if (priceString.isEmpty()) {
                value = getStock().getPrice() * quantityTemp;
                buyTemp = new Buy(quantityTemp);
            } else {
                priceTemp = Integer.parseInt(priceString);
                value = priceTemp * quantityTemp;
                buyTemp = new Buy(priceTemp, quantityTemp);
            }
        });
    }

    private Stock getStock() {
        switch (stock.getValue()) {
            case "AAPL | Apple Inc.":
                return Stock.APPLE;
            case "AMZN | Amazon.com, Inc.":
                return Stock.AMAZON;
            case "FB | Facebook, Inc.":
                return Stock.FACEBOOK;
            case "NFLX | Netflix, Inc.":
                return Stock.NETFLIX;
            case "TSLA | Tesla, Inc.":
                return Stock.TESLA;
            case "GOOG | Alphabet Inc.":
                return Stock.GOOGLE;
            default:
        }
        return null;
    }
}

//Arrays.toString(ints).replaceAll("[\\[\\],]", ""); to change the array into a string for the changeLine method for amending the file

