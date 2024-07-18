package Stockmarket;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Stockmarket {
    private Map<String, Stock> stocks;

    public Stockmarket() {
        this.stocks = new HashMap<>();
        // Initialize with some stocks
        stocks.put("AAPL", new Stock("AAPL", "Apple Inc.", 150.0));
        stocks.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 2800.0));
        stocks.put("AMZN", new Stock("AMZN", "Amazon.com Inc.", 3400.0));
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    public void updateStockPrices() {
        Random rand = new Random();
        for (Stock stock : stocks.values()) {
            double change = (rand.nextDouble() * 2 - 1) * 0.05 * stock.getPrice(); // ±5% change
            stock.setPrice(stock.getPrice() + change);
        }
    }

    public Map<String, Stock> getStocks() {
        return stocks;
    }
}
