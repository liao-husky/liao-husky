package model.ProductManagement;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private String name;
    private Map<String, Double> marketPrices; // Market-specific pricing
    private Map<String, Double> channelPrices; // Channel-specific pricing

    public Product(String name, double floorPrice, double ceilingPrice, double targetPrice) {
        this.name = name;
        this.marketPrices = new HashMap<>();
        this.channelPrices = new HashMap<>();

        // Initialize with the provided prices for a default market and channel
        // (Optional: you can initialize these if needed for default values)
        setMarketPrice("DefaultMarket", floorPrice);
        setChannelPrice("DefaultChannel", targetPrice);
    }

    // Method to set market-specific price
    public void setMarketPrice(String market, double price) {
        marketPrices.put(market, price);
    }

    // Method to set channel-specific price
    public void setChannelPrice(String channel, double price) {
        channelPrices.put(channel, price);
    }

    // This method now accepts a market and channel to return the specific price
    public double getPrice(String market, String channel) {
        // Return the sum of the market price and channel price for the given market and channel
        return marketPrices.getOrDefault(market, 0.0) + channelPrices.getOrDefault(channel, 0.0);
    }

    // Getter for product name
    public String getName() {
        return name;
    }

    // Assuming the market price is the floor price, you can adjust this as needed.
    public double getFloorPrice() {
        return marketPrices.isEmpty() ? 0.0 : marketPrices.values().stream().min(Double::compareTo).orElse(0.0);
    }

    // Assuming the market price is the ceiling price, you can adjust this as needed.
    public double getCeilingPrice() {
        return marketPrices.isEmpty() ? 0.0 : marketPrices.values().stream().max(Double::compareTo).orElse(0.0);
    }
}
