package model;

import model.CustomerManagement.CustomerDirectory;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.Supplier.SupplierDirectory;
import model.reports.AdvertisingEfficiencyReport;
import model.reports.ChannelProfitabilityReport;
import model.reports.MarketProfitabilityReport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Business {
    private SupplierDirectory supplierDirectory;
    private PersonDirectory personDirectory;
    private CustomerDirectory customerDirectory;
    private MasterOrderList masterOrderList;

    private List<Market> markets;
    private List<Channel> channels;
    private List<SolutionOffer> solutionOffers;
    private AdvertisingCosts advertisingCosts;

    public Business(String name) {
        this();
        System.out.println("Business created: " + name);
    }

    public Business() {
        this.markets = new ArrayList<>();
        this.channels = new ArrayList<>();
        this.solutionOffers = new ArrayList<>();
        this.supplierDirectory = new SupplierDirectory();
        this.personDirectory = new PersonDirectory();
        this.customerDirectory = new CustomerDirectory();
        this.masterOrderList = new MasterOrderList();
        this.advertisingCosts = new AdvertisingCosts();
    }

    public Business(List<Market> markets, List<Channel> channels, List<SolutionOffer> solutionOffers) {
        this();
        this.markets = markets;
        this.channels = channels;
        this.solutionOffers = solutionOffers;
    }

    // Accessor methods
    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterOrderList;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public List<SolutionOffer> getSolutionOffers() {
        return solutionOffers;
    }

    public AdvertisingCosts getAdvertisingCosts() {
        return advertisingCosts;
    }

    // Generate sample orders
    public List<Order> generateSampleOrders() {
        List<Order> orders = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) { // Generate 100 orders
            Order order = new Order();

            // Pick random market and channel
            Market market = markets.get(random.nextInt(markets.size()));
            Channel channel = channels.get(random.nextInt(channels.size()));

            // Add order items
            for (int j = 0; j < random.nextInt(5) + 1; j++) { // Each order has 1-5 items
                Product product = new Product("Product " + (j + 1), 10 + random.nextDouble() * 90, 20, 50); // Random prices
                order.addItem(new OrderItem(product, market, channel, random.nextInt(10) + 1)); // Random quantity
            }

            orders.add(order);
        }

        return orders;
    }

    // Report generation methods

    // Market Profitability Report
    public void generateMarketProfitabilityReport(List<Order> orders) {
        System.out.println("Generating Market Profitability Report...");
        MarketProfitabilityReport.generateMarketReport(orders, markets, advertisingCosts);
    }

    // Channel Profitability Report
    public void generateChannelProfitabilityReport(List<Order> orders) {
        System.out.println("Generating Channel Profitability Report...");
        ChannelProfitabilityReport.generateChannelReport(orders, channels, advertisingCosts);
    }

    // Advertising Efficiency Report
    public void generateAdvertisingEfficiencyReport(List<Order> orders) {
        System.out.println("Generating Advertising Efficiency Report...");
        AdvertisingEfficiencyReport.generateEfficiencyReport(orders, markets, channels, advertisingCosts);
    }

    // Example of how you would call the report generation methods
    public void generateReports(List<Order> orders) {
        generateMarketProfitabilityReport(orders);
        generateChannelProfitabilityReport(orders);
        generateAdvertisingEfficiencyReport(orders);
    }

    // Example method to simulate how the business works
    public void startBusiness() {
        // Generate sample orders
        List<Order> orders = generateSampleOrders();

        // Call generateReports to print all the reports
        generateReports(orders);
    }
}
