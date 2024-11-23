import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public double getTotalSpent() {
        return orders.stream().mapToDouble(Order::getTotalCost).sum();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }
}
