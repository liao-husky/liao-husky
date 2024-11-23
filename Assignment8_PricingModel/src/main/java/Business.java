import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Business {
    private List<Supplier> suppliers;
    private List<Customer> customers;

    public Business() {
        this.suppliers = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void generateSuppliersReport() {
    }
}
        