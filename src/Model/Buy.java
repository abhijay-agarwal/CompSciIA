package Model;

public class Buy {

    private int quantity;
    private int price;

    public Buy(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public Buy(int quantity) {
        this.price = 999999999;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        if (this.getPrice() == 999999999) {
            return ("Buy " + quantity + " units at market price");
        } else {
            return ("Buy " + quantity + " units at $" + price);
        }
    }
}
