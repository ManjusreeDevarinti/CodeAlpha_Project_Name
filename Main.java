package Stockmarket;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TradingPlatform platform = new TradingPlatform();
        Scanner scanner = new Scanner(System.in);

        // Register users
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        platform.registerUser(username, balance);

        boolean running = true;
        while (running) {
            System.out.println("\n1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    platform.getMarket().updateStockPrices();
                    System.out.println("Market Data:");
                    for (Map.Entry<String, Stock> entry : platform.getMarket().getStocks().entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue().getName() + " @ $" + entry.getValue().getPrice());
                    }
                    break;
                case 2:
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int buyQuantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (platform.buyStock(username, buySymbol, buyQuantity)) {
                        System.out.println("Stock purchased successfully");
                    } else {
                        System.out.println("Failed to purchase stock");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (platform.sellStock(username, sellSymbol, sellQuantity)) {
                        System.out.println("Stock sold successfully");
                    } else {
                        System.out.println("Failed to sell stock");
                    }
                    break;
                case 4:
                    platform.printUserPortfolio(username);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

        scanner.close();
    }
}




