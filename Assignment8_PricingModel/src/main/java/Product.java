public class Product {
    private String name;
    private double price;
    private int sales;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.sales = 0;
    }

    public void recordSale(int quantity) {
        this.sales += quantity;
    }

    public double getTotalSales() {
        return sales * price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getSales() {
        return sales;
    }
}
