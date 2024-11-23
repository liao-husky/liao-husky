import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private String name;
    private List<Product> products;

    public Supplier(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getMostExpensiveProduct() {
        return products.stream().max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).orElse(null);
    }

    public double getTotalSales() {
        return products.stream().mapToDouble(Product::getTotalSales).sum();
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
