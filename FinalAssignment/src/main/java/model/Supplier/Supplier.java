package model.Supplier;

import model.ProductCatalog;

public class Supplier {
    private String name; // Supplier's name
    private ProductCatalog productCatalog; // Catalog of products the supplier manages
    private double totalSales; // Total sales for this supplier

    public Supplier(String name) {
        this.name = name;
        this.productCatalog = new ProductCatalog(); // Initialize an empty product catalog
        this.totalSales = 0.0;
    }

    // Get the supplier's name
    public String getName() {
        return name;
    }

    // Get the supplier's product catalog
    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    // Add a product to the supplier's catalog
    public void addProduct(String productName, double floorPrice, double ceilingPrice, double targetPrice) {
        productCatalog.newProduct(productName, floorPrice, ceilingPrice, targetPrice);
    }

    // Update total sales when a product is sold
    public void addSales(double amount) {
        totalSales += amount;
    }

    // Get the supplier's total sales
    public double getTotalSales() {
        return totalSales;
    }

    // ToString method for easier display
    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", totalSales=" + totalSales +
                '}';
    }
}
