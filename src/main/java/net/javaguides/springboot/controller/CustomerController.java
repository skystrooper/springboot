package net.javaguides.springboot.controller;

import net.javaguides.springboot.exceptions.CustomerNotFoundException;
import net.javaguides.springboot.model.Customer;
import net.javaguides.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> findAllCustomers() {
        return service.getCustomers();
    }

    @GetMapping("{id}")
    public Customer findCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    @GetMapping("/name/{name}")
    public Customer getCustomerByName(@PathVariable String name){
        return service.GetCustomerByName(name);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.updateProduct(customer);
    }

    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteCustomer(id);
    }
}