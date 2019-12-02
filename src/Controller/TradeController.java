package Controller;

import Database.Database;
import Model.Buy;
import Model.SceneController;
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TradeController {

    public double value;
    public double priceTemp;
    public int quantityTemp;

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
    private Button back;

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

            try {
                ArrayList<String> stocks = new ArrayList<>();
                Scanner scanner = new Scanner(new File(Database.getStockPath()));
                while (scanner.hasNext()) {
                    stocks.add(scanner.nextLine());
                }
                int[] array = Arrays.stream(stocks.get(LoginController.getIndex()).split("\\s")).mapToInt(Integer::parseInt).toArray();
                System.out.println(Arrays.toString(array));
                array[getIndex()] = quantityTemp;
                System.out.println(Arrays.toString(array));
                Database.changeLine(Database.getStockPath(), Arrays.toString(array).replaceAll("[\\[\\],]", ""), LoginController.getIndex());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        back.setOnAction(event -> new SceneController(anchorPane).activate("Home"));
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

    private int getIndex() {
        switch (stock.getValue()) {
            case "AAPL | Apple Inc.":
                return 0;
            case "AMZN | Amazon.com, Inc.":
                return 1;
            case "FB | Facebook, Inc.":
                return 2;
            case "NFLX | Netflix, Inc.":
                return 3;
            case "TSLA | Tesla, Inc.":
                return 4;
            case "GOOG | Alphabet Inc.":
                return 5;
            default:
        }
        return 0;
    }

}

//Arrays.toString(ints).replaceAll("[\\[\\],]", ""); to change the array into a string for the changeLine method for amending the file

