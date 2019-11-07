package Controller;

import Database.Database;
import Model.Stock;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class PortfolioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField appleValue;

    @FXML
    private TextField cash;

    @FXML
    private TextField facebookValue;

    @FXML
    private TextField teslaValue;

    @FXML
    private TextField googleValue;

    @FXML
    private TextField netflixValue;

    @FXML
    private TextField amazonValue;

    @FXML
    private Text apple;

    @FXML
    private Text amazon;

    @FXML
    private Text facebook;

    @FXML
    private Text netflix;

    @FXML
    private Text tesla;

    @FXML
    private Text google;

    @FXML
    void initialize() throws FileNotFoundException {
        int[] array = Database.getStocks(LoginController.getIndex());

        apple.setText(Integer.toString(array[Stock.APPLE.getIndex()]));
        amazon.setText(Integer.toString(array[Stock.AMAZON.getIndex()]));
        facebook.setText(Integer.toString(array[Stock.FACEBOOK.getIndex()]));
        netflix.setText(Integer.toString(array[Stock.NETFLIX.getIndex()]));
        tesla.setText(Integer.toString(array[Stock.TESLA.getIndex()]));
        google.setText(Integer.toString(array[Stock.GOOGLE.getIndex()]));

        appleValue.setText(Double.toString(array[Stock.APPLE.getIndex()] * (Stock.APPLE.getPrice())));
        amazonValue.setText(Double.toString(array[Stock.AMAZON.getIndex()] * (Stock.AMAZON.getPrice())));
        facebookValue.setText(Double.toString(array[Stock.FACEBOOK.getIndex()] * (Stock.FACEBOOK.getPrice())));
        netflixValue.setText(Double.toString(array[Stock.NETFLIX.getIndex()] * (Stock.NETFLIX.getPrice())));
        teslaValue.setText(Double.toString(array[Stock.TESLA.getIndex()] * (Stock.TESLA.getPrice())));
        googleValue.setText(Double.toString(array[Stock.GOOGLE.getIndex()] * (Stock.GOOGLE.getPrice())));
    }
}
