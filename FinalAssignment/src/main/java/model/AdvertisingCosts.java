package model;

import java.util.HashMap;
import java.util.Map;

public class AdvertisingCosts {
    private Map<String, Double> marketCosts; // Costs per market
    private Map<String, Double> channelCosts; // Costs per channel

    public AdvertisingCosts() {
        this.marketCosts = new HashMap<>();
        this.channelCosts = new HashMap<>();
    }

    /**
     * Sets the advertising cost for a specific market.
     * Ensures the cost is non-negative.
     */
    public void setMarketCost(String market, double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Market cost cannot be negative.");
        }
        marketCosts.put(market, cost);
    }

    /**
     * Sets the advertising cost for a specific channel.
     * Ensures the cost is non-negative.
     */
    public void setChannelCost(String channel, double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Channel cost cannot be negative.");
        }
        channelCosts.put(channel, cost);
    }

    /**
     * Retrieves the advertising cost for a specific market.
     * If not found, defaults to 0.0.
     */
    public double getMarketCost(String market) {
        return marketCosts.getOrDefault(market, 0.0);
    }

    /**
     * Retrieves the advertising cost for a specific channel.
     * If not found, defaults to 0.0.
     */
    public double getChannelCost(String channel) {
        return channelCosts.getOrDefault(channel, 0.0);
    }

    /**
     * Removes the advertising cost entry for a specific market.
     */
    public void removeMarketCost(String market) {
        marketCosts.remove(market);
    }

    /**
     * Removes the advertising cost entry for a specific channel.
     */
    public void removeChannelCost(String channel) {
        channelCosts.remove(channel);
    }

    /**
     * Returns a map of all market costs for reporting purposes.
     */
    public Map<String, Double> getAllMarketCosts() {
        return new HashMap<>(marketCosts); // Return a copy to ensure immutability
    }

    /**
     * Returns a map of all channel costs for reporting purposes.
     */
    public Map<String, Double> getAllChannelCosts() {
        return new HashMap<>(channelCosts); // Return a copy to ensure immutability
    }

    @Override
    public String toString() {
        return "AdvertisingCosts {" +
                "marketCosts=" + marketCosts +
                ", channelCosts=" + channelCosts +
                '}';
    }
}
