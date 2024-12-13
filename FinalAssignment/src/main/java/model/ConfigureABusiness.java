package model;

import model.Business;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.Faker;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

import java.util.Random;

public class ConfigureABusiness {

    private static final int LOWER_PRICE_LIMIT = 10;
    private static final int UPPER_PRICE_LIMIT = 100;
    private static final int PRODUCT_MAX_QUANTITY = 5;

    public static Business createABusinessAndLoadData(String name, int supplierCount, int productCount,
                                                      int customerCount, int orderCount, int itemCount) {
        Business business = new Business(name);

        loadSuppliers(business, supplierCount);
        loadProducts(business, productCount);
        loadCustomers(business, customerCount);
        loadOrders(business, orderCount, itemCount);

        return business;
    }

    private static void loadSuppliers(Business business, int supplierCount) {
        Faker faker = new Faker();
        SupplierDirectory supplierDirectory = business.getSupplierDirectory();

        for (int i = 0; i < supplierCount; i++) {
            supplierDirectory.newSupplier(faker.company().name());
        }
    }

    private static void loadProducts(Business business, int productCount) {
        SupplierDirectory supplierDirectory = business.getSupplierDirectory();

        for (Supplier supplier : supplierDirectory.getSupplierList()) {
            for (int i = 0; i < productCount; i++) {
                String productName = "Product " + (i + 1) + " by " + supplier.getName();
                double floorPrice = getRandom(LOWER_PRICE_LIMIT, UPPER_PRICE_LIMIT - 20);
                double ceilingPrice = getRandom(floorPrice + 5, UPPER_PRICE_LIMIT);
                double targetPrice = getRandom(floorPrice + 5, ceilingPrice - 5);
                supplier.addProduct(productName, floorPrice, ceilingPrice, targetPrice);
            }
        }
    }

    private static void loadCustomers(Business business, int customerCount) {
        Faker faker = new Faker();
        PersonDirectory personDirectory = business.getPersonDirectory();
        CustomerDirectory customerDirectory = business.getCustomerDirectory();

        for (int i = 0; i < customerCount; i++) {
            Person person = personDirectory.newPerson(faker.name().fullName());
            customerDirectory.newCustomerProfile(person);
        }
    }

    private static void loadOrders(Business business, int orderCount, int itemCount) {
        MasterOrderList orderList = business.getMasterOrderList();
        CustomerDirectory customerDirectory = business.getCustomerDirectory();
        SupplierDirectory supplierDirectory = business.getSupplierDirectory();
        Random random = new Random();

        for (int i = 0; i < orderCount; i++) {
            CustomerProfile customer = customerDirectory.pickRandomCustomer();
            if (customer == null) continue;

            Order order = orderList.newOrder(customer);

            for (int j = 0; j < itemCount; j++) {
                Supplier supplier = supplierDirectory.pickRandomSupplier();
                if (supplier == null) continue;

                Product product = supplier.getProductCatalog().pickRandomProduct();
                if (product == null) continue;

                double price = getRandom(product.getFloorPrice(), product.getCeilingPrice());
                int quantity = random.nextInt(PRODUCT_MAX_QUANTITY) + 1;

                order.addItem(new OrderItem(product, price, quantity));
            }

            customer.addCustomerOrder(order);
        }
    }

    private static double getRandom(double min, double max) {
        return min + new Random().nextDouble() * (max - min);
    }

    public static Business createSampleBusiness() {
        // Example: Create a sample business with dummy data
        return createABusinessAndLoadData("Sample Business", 5, 10, 20, 50, 3);
    }
}
