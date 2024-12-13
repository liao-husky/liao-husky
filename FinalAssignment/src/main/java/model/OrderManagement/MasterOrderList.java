package model.OrderManagement;

import model.CustomerManagement.CustomerProfile;

import java.util.ArrayList;
import java.util.List;

public class MasterOrderList {
    private List<Order> orders;

    public MasterOrderList() {
        this.orders = new ArrayList<>();
    }

    // Create a new order for a given customer
    public Order newOrder(CustomerProfile customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }

        Order order = new Order();
        orders.add(order);
        return order;
    }

    // Get all orders
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Master Order List:\n");
        for (Order order : orders) {
            sb.append(order).append("\n");
        }
        return sb.toString();
    }
}
