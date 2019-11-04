package Model;

/**
 * Enum created by Abhi
 */

public enum Stock {

    APPLE("AAPL", "Apple Inc.", 0.0),
    AMAZON("AMZN", "Amazon.com Inc.", 0.0),
    FACEBOOK("FB", "Facebook Inc.", 0.0),
    NETFLIX("NFLX", "Netflix Inc.", 0.0),
    TESLA("TSLA", "Tesla Inc.", 0.0),
    GOOGLE("GOOG", "Alphabet Inc.", 0.0);

    private final String ticker;
    private final String name;
    private final double price;

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

    Stock(String ticker, String name, double price) {
        this.ticker = ticker;
        this.name = name;
        this.price = price;
    }

}
