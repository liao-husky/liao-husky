import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
        item.getProduct().recordSale(item.getQuantity());
    }

    public double getTotalCost() {
        return items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
