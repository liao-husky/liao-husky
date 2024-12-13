package model;

import model.ProductManagement.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductCatalog {
    private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void newProduct(String name, double floorPrice, double ceilingPrice, double targetPrice) {
        products.add(new Product(name, floorPrice, ceilingPrice, targetPrice));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product pickRandomProduct() {
        if (products.isEmpty()) return null;
        Random random = new Random();
        return products.get(random.nextInt(products.size()));
    }
}
