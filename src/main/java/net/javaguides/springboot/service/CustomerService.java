package net.javaguides.springboot.service;

import net.javaguides.springboot.ICustomerService;
import net.javaguides.springboot.model.Customer;
import net.javaguides.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository repository;

    String newId = UUID.randomUUID().toString();

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getCustomers() {
        return repository.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id);
    }

    public String deleteCustomer(int id) {
        repository.delete(id);
        return "product removed !! " + id;
    }

    public Customer updateProduct(Customer customer) {
        return repository.update(customer);
    }
}