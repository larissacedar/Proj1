package Service;

import DAO.CustomerRepository;
import Model.Customer;
import Model.Order;

import java.util.List;

public class CustomerDetails {
    CustomerRepository cr;

    public CustomerDetails() {
        cr = new CustomerRepository();

    }

    public int getCustomerIdFromName(String name) {
        return cr.getCustomerIdFromName(name);
    }
    public List<Customer>  getAllCustomers() {
        return cr.getAllCustomers();
    }
    public void addCustomer(int id, String name, String petname) {
        Customer existingCustomer = cr.getOrderByID(id);
        //Customer newCustomer = true;
        if (existingCustomer == null) {
            Customer newCustomer = new Customer(id, name, petname);
            cr.addCustomer(newCustomer);
        } else {
        }
    }
}