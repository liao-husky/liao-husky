package model.reports;

import model.AdvertisingCosts;
import model.Channel;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;

import java.util.List;

public class ChannelProfitabilityReport {

    public static void generateChannelReport(List<Order> orders, List<Channel> channels, AdvertisingCosts advertisingCosts) {
        System.out.println("\nChannel Profitability Report:");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s%n", "Channel", "Total Sales", "Ad Cost", "Orders", "Efficiency");

        for (Channel channel : channels) {
            double totalSales = 0;
            double advertisingCost = advertisingCosts.getChannelCost(channel.getName());
            int totalOrders = 0;

            for (Order order : orders) {
                for (OrderItem item : order.getItems()) {
                    // Check if the channel is null
                    if (item.getChannel() != null && item.getChannel().equals(channel)) {
                        totalSales += item.getTotalPrice();
                        totalOrders++;
                    }
                }
            }

            double efficiency = (totalOrders > 0) ? totalSales / totalOrders : 0; // Avoid division by zero
            System.out.printf("%-15s %-15.2f %-15.2f %-15d %-15.2f%n", channel.getName(), totalSales, advertisingCost, totalOrders, efficiency);
        }
    }
}
