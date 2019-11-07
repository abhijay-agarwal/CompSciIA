package Model;

public class Buy {

    private double quantity;
    private double price;

    public Buy(double price, double quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public Buy(double quantity) {
        this.price = 999999999;
        this.quantity = quantity;
    }

    public double getPrice() { return price; }

    public double getQuantity() {
        return quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        if (this.getPrice() == 999999999) {
            return ("Buy " + quantity + " units at market price");
        } else {
            return ("Buy " + quantity + " units at $" + price);
        }
    }

}
