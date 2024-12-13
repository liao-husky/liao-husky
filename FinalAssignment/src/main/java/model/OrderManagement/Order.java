package model.OrderManagement;

import model.CustomerManagement.CustomerProfile;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private CustomerProfile customer;
    private List<OrderItem> items;

    public Order() {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    // Add an item to the order
    public void addItem(OrderItem item) {
        if (item != null) {
            items.add(item);
        }
    }

    // Calculate the total cost of the order
    public double getOrderTotal() {
        return items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }

    public CustomerProfile getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order for Customer: ");
        sb.append(customer.getCustomerId()).append("\nItems:\n");
        for (OrderItem item : items) {
            sb.append("  - ").append(item).append("\n");
        }
        sb.append("Total: $").append(getOrderTotal());
        return sb.toString();
    }
}
