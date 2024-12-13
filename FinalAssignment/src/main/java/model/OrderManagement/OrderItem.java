package model.OrderManagement;

import model.Channel;
import model.Market;
import model.ProductManagement.Product;

public class OrderItem {
    private Product product;
    private double price;
    private int quantity;

    public OrderItem(Product product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItem(Product product, Market market, Channel channel, int i) {
    }

    // Calculate the total price for the item
    public double getTotalPrice() {
        return price * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " | Price: $" + price + " | Quantity: " + quantity + " | Total: $" + getTotalPrice();
    }

    public Object getChannel() {
        return null;
    }

    public Object getMarket() {
        return null;
    }
}
