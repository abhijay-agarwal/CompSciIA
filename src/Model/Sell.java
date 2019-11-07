package Model;

/**
 * Class created by Abhi
 */

public class Sell {

    double quantity;
    double price;

    public Sell(double price, double quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public Sell(double quantity) {
        this.price = 0;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        if(this.getPrice() == 0) {
            return("Sell " + quantity + " units at market price");
        } else {
            return("Sell " + quantity + " units at $" + price);
        }
    }
}
