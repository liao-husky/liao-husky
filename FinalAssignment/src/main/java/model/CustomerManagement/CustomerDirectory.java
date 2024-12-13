package model.CustomerManagement;

import model.Personnel.Person;

import java.util.ArrayList;
import java.util.List;

public class CustomerDirectory {
    private List<CustomerProfile> customerList;

    public CustomerDirectory() {
        customerList = new ArrayList<>();
    }

    public CustomerProfile newCustomerProfile(Person person) {
        CustomerProfile customer = new CustomerProfile(person);
        customerList.add(customer);
        return customer;
    }

    public CustomerProfile pickRandomCustomer() {
        if (customerList.isEmpty()) return null;
        return customerList.get((int) (Math.random() * customerList.size()));
    }

    public List<CustomerProfile> getCustomerList() {
        return customerList;
    }
}
