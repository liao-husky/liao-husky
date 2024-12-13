package model.CustomerManagement;

import model.OrderManagement.Order;
import model.Personnel.Person;

import java.util.ArrayList;
import java.util.List;

public class CustomerProfile {
    private Person person; // Associated person object
    private List<Order> customerOrders; // List of orders placed by the customer

    public CustomerProfile(Person person) {
        this.person = person;
        this.customerOrders = new ArrayList<>();
    }

    // Adds an order to the customer's list of orders
    public void addCustomerOrder(Order order) {
        if (order != null) {
            customerOrders.add(order);
        }
    }

    // Retrieves the list of all orders for the customer
    public List<Order> getCustomerOrders() {
        return customerOrders;
    }

    // Calculates the total spending of the customer
    public double getTotalSpent() {
        return customerOrders.stream()
                .mapToDouble(Order::getOrderTotal)
                .sum();
    }

    // Returns the associated Person object
    public Person getPerson() {
        return person;
    }

    // Returns the customer's name
    public String getCustomerName() {
        return person.getName();
    }

    // Returns the customer's ID
    public String getCustomerId() {
        return person.getPersonId();
    }

    // Checks if the CustomerProfile matches a specific Person ID
    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    @Override
    public String toString() {
        return "Customer: " + person.getName() + ", Total Spent: $" + getTotalSpent();
    }
}
