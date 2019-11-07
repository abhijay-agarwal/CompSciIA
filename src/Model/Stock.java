package Model;

/**
 * Enum created by Abhi
 */

public enum Stock {

    APPLE(0, "AAPL", "Apple Inc.", 257.69),
    AMAZON(1, "AMZN", "Amazon.com, Inc.", 1805.00),
    FACEBOOK(2, "FB", "Facebook, Inc.", 194.10),
    NETFLIX(3, "NFLX", "Netflix, Inc.", 288.67),
    TESLA(4, "TSLA", "Tesla, Inc.", 319.04),
    GOOGLE(5, "GOOG", "Alphabet Inc.", 1296.62);

    private final String ticker;
    private final String name;
    private final double price;
    private final int index;

    public int getIndex() {
        return index;
    }

    public String getTicker() {
        return ticker;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static double[] getPrices() {
        return new double[]{APPLE.getPrice(), AMAZON.getPrice(), FACEBOOK.getPrice(),
                NETFLIX.getPrice(), TESLA.getPrice(), GOOGLE.getPrice()};
    }

    Stock(int index, String ticker, String name, double price) {
        this.index = index;
        this.ticker = ticker;
        this.name = name;
        this.price = price;
    }


}
