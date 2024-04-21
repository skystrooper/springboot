package net.javaguides.springboot;

import net.javaguides.springboot.model.Customer;

import java.util.List;

public interface ICustomerService {



    public Customer saveCustomer(Customer customer);

    List<Customer> getCustomers();

    Customer getCustomerById(int id);

    String deleteCustomer(int id);

    Customer updateProduct(Customer customer);

}
