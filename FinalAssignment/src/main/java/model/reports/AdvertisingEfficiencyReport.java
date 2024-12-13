package model.reports;

import model.AdvertisingCosts;
import model.Channel;
import model.Market;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;

import java.util.List;

public class AdvertisingEfficiencyReport {

    public static void generateEfficiencyReport(List<Order> orders, List<Market> markets, List<Channel> channels, AdvertisingCosts advertisingCosts) {
        System.out.println("\nAdvertising Efficiency Report:");
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Market", "Channel", "Ad Cost", "Sales");

        for (Market market : markets) {
            for (Channel channel : channels) {
                double totalSales = 0;
                double advertisingCost = advertisingCosts.getMarketCost(market.getName()) / markets.size()
                        + advertisingCosts.getChannelCost(channel.getName()) / channels.size();

                // Loop through all orders and calculate sales for the specific market and channel
                for (Order order : orders) {
                    for (OrderItem item : order.getItems()) {
                        // Check if both market and channel are not null and match
                        if (item.getMarket() != null && item.getMarket().equals(market)
                                && item.getChannel() != null && item.getChannel().equals(channel)) {
                            totalSales += item.getTotalPrice();
                        }
                    }
                }

                // Output the efficiency report
                System.out.printf("%-15s %-15s %-15.2f %-15.2f%n", market.getName(), channel.getName(), advertisingCost, totalSales);
            }
        }
    }
}
