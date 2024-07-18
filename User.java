package Stockmarket;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private double balance;
    private Map<Stock, Integer> portfolio;

    public User(String username, double balance) {
        this.username = username;
        this.balance = balance;
        this.portfolio = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Map<Stock, Integer> getPortfolio() {
        return portfolio;
    }
}
