package Stockmarket;
import java.util.HashMap;
import java.util.Map;

public class TradingPlatform {
    private Stockmarket market;
    private Map<String, User> users;

    public TradingPlatform() {
        this.market = new Stockmarket();
        this.users = new HashMap<>();
    }

    public void registerUser(String username, double initialBalance) {
        users.put(username, new User(username, initialBalance));
    }

    public boolean buyStock(String username, String symbol, int quantity) {
        User user = users.get(username);
        Stock stock = market.getStock(symbol);
        if (user != null && stock != null) {
            double cost = stock.getPrice() * quantity;
            if (user.getBalance() >= cost) {
                user.setBalance(user.getBalance() - cost);
                user.getPortfolio().put(stock, user.getPortfolio().getOrDefault(stock, 0) + quantity);
                return true;
            }
        }
        return false;
    }

    public boolean sellStock(String username, String symbol, int quantity) {
        User user = users.get(username);
        Stock stock = market.getStock(symbol);
        if (user != null && stock != null) {
            int ownedQuantity = user.getPortfolio().getOrDefault(stock, 0);
            if (ownedQuantity >= quantity) {
                double revenue = stock.getPrice() * quantity;
                user.setBalance(user.getBalance() + revenue);
                if (ownedQuantity == quantity) {
                    user.getPortfolio().remove(stock);
                } else {
                    user.getPortfolio().put(stock, ownedQuantity - quantity);
                }
                return true;
            }
        }
        return false;
    }

    public void printUserPortfolio(String username) {
        User user = users.get(username);
        if (user != null) {
            System.out.println("Portfolio for " + user.getUsername() + ":");
            for (Map.Entry<Stock, Integer> entry : user.getPortfolio().entrySet()) {
                System.out.println(entry.getKey().getName() + " (" + entry.getKey().getSymbol() + "): " + entry.getValue() + " shares @ $" + entry.getKey().getPrice());
            }
            System.out.println("Balance: $" + user.getBalance());
        } else {
            System.out.println("User not found");
        }
    }

    public Stockmarket getMarket() {
        return market;
    }
}
