package model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierDirectory {
    private List<Supplier> supplierList;

    public SupplierDirectory() {
        supplierList = new ArrayList<>();
    }

    public Supplier newSupplier(String name) {
        Supplier supplier = new Supplier(name);
        supplierList.add(supplier);
        return supplier;
    }

    public Supplier pickRandomSupplier() {
        if (supplierList.isEmpty()) return null;
        return supplierList.get((int) (Math.random() * supplierList.size()));
    }

    public List<Supplier> getSupplierList() {
        return supplierList;
    }
}
