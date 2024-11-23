import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Step 1: Populate the model
        Business business = new Business();

        // Add 30 Suppliers
        for (int i = 1; i <= 30; i++) {
            business.addSupplier(new Supplier("Supplier " + i));
        }

        // Pick 10 Suppliers and add 20 Products each
        List<Supplier> selectedSuppliers = business.getSuppliers().subList(0, 10);
        Random random = new Random();
        for (Supplier supplier : selectedSuppliers) {
            for (int j = 1; j <= 20; j++) {
                supplier.addProduct(new Product("Product " + j, 10 + random.nextDouble() * 90)); // Price between 10-100
            }
        }

        // Add 50 Customers
        for (int i = 1; i <= 50; i++) {
            business.addCustomer(new Customer("Customer " + i));
        }

        // Pick 25 Customers and add 1-3 Orders with 1-10 Items each
        List<Customer> selectedCustomers = business.getCustomers().subList(0, 25);
        for (Customer customer : selectedCustomers) {
            int ordersCount = random.nextInt(3) + 1; // 1-3 orders
            for (int k = 0; k < ordersCount; k++) {
                Order order = new Order();
                for (int l = 0; l < random.nextInt(10) + 1; l++) { // 1-10 items
                    Supplier supplier = selectedSuppliers.get(random.nextInt(selectedSuppliers.size()));
                    Product product = supplier.getProducts().get(random.nextInt(supplier.getProducts().size()));
                    order.addItem(new OrderItem(product, random.nextInt(5) + 1)); // Quantity 1-5
                }
                customer.addOrder(order);
            }
        }

        // Part 2: Answer Questions
        // 1. Pick three random Customers and print out their Sales Orders
        System.out.println("\nSales Orders for 3 Random Customers:");
        for (int i = 0; i < 3; i++) {
            Customer customer = business.getCustomers().get(random.nextInt(business.getCustomers().size()));
            System.out.println("Customer: " + customer.getName());
            for (Order order : customer.getOrders()) {
                System.out.println("  Order Total: $" + order.getTotalCost());
            }
        }

        // 2. Pick three random Suppliers and find their most expensive products
        System.out.println("\nMost Expensive Products for 3 Random Suppliers:");
        for (int i = 0; i < 3; i++) {
            Supplier supplier = business.getSuppliers().get(random.nextInt(business.getSuppliers().size()));
            Product expensiveProduct = supplier.getMostExpensiveProduct();
            System.out.println("Supplier: " + supplier.getName() + ", Product: " + expensiveProduct.getName() +
                    ", Price: $" + expensiveProduct.getPrice());
        }

        // 3. Find a customer who spent the most money
        Customer topCustomer = business.getCustomers().stream()
                .max(Comparator.comparingDouble(Customer::getTotalSpent))
                .orElse(null);
        if (topCustomer != null) {
            System.out.println("\nTop Customer: " + topCustomer.getName() + ", Total Spent: $" + topCustomer.getTotalSpent());
        }

        // 4. Find a Supplier with most sales
        Supplier topSupplier = business.getSuppliers().stream()
                .max(Comparator.comparingDouble(Supplier::getTotalSales))
                .orElse(null);
        if (topSupplier != null) {
            System.out.println("\nTop Supplier: " + topSupplier.getName() + ", Total Sales: $" + topSupplier.getTotalSales());
        }

        // 5. Find a Supplier with least sales (excluding zero sales)
        Supplier leastSupplier = business.getSuppliers().stream()
                .filter(supplier -> supplier.getTotalSales() > 0)
                .min(Comparator.comparingDouble(Supplier::getTotalSales))
                .orElse(null);
        if (leastSupplier != null) {
            System.out.println("\nLeast Supplier: " + leastSupplier.getName() + ", Total Sales: $" + leastSupplier.getTotalSales());
        }

        // Part 3: Suppliers Report
        business.generateSuppliersReport();
    }
}
