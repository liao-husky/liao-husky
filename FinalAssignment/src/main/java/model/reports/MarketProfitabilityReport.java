package model.reports;

import model.AdvertisingCosts;
import model.Market;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketProfitabilityReport {

    public static void generateMarketReport(List<Order> orders, List<Market> markets, AdvertisingCosts advertisingCosts) {
        System.out.println("\nMarket Profitability Report:");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s%n", "Market", "Product", "Total Sales", "Ad Cost", "Profit");

        Map<String, Double> marketSales = new HashMap<>();
        Map<String, Double> marketProfits = new HashMap<>();

        for (Market market : markets) {
            double totalSales = 0;
            double advertisingCost = advertisingCosts.getMarketCost(market.getName());

            for (Order order : orders) {
                for (OrderItem item : order.getItems()) {
                    // Check if the market is null
                    if (item.getMarket() != null && item.getMarket().equals(market)) {
                        totalSales += item.getTotalPrice();
                    }
                }
            }

            double profit = totalSales - advertisingCost;
            marketSales.put(market.getName(), totalSales);
            marketProfits.put(market.getName(), profit);

            System.out.printf("%-15s %-15s %-15.2f %-15.2f %-15.2f%n", market.getName(), "ALL", totalSales, advertisingCost, profit);
        }
    }
}
