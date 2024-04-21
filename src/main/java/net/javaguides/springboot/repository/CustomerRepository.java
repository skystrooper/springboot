package net.javaguides.springboot.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.javaguides.springboot.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {


    private List<Customer> list = new ArrayList<Customer>();

    public void createProducts() {

        list = List.of(
                new Customer(1, "n1", 1834720, "abcdedfffgd", "newId"),
                new Customer(2, "n2", 20816830, "jknjsiusvdsfvd", "newId"),
                new Customer(3, "n3", 58279420, "chshgvbusdtsugu", "newId")
        );
    }

    public List<Customer> getAllCustomers() {
        return list;
    }

    public Customer findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Customer> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public Customer save(Customer p) {

        String newId = UUID.randomUUID().toString();

        Customer customer = new Customer(1, "Customer 1", 1834720, "abcdedfffgd", "NewID");
        customer.setId(p.getId());
        customer.setName(p.getName());
        customer.setPhone(p.getPhone());
        customer.setAddress(p.getAddress());
        customer.setCustomerId(newId);
        list.add(customer);
        return customer;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Customer update(Customer customer) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (customer.getId())) {
                id = customer.getId();
                idx = i;
                break;
            }
        }

        Customer customer1 = new Customer(1, "customer 1", 1834720, "abcdedfffgd", "newId");
        customer1.setId(id);
        customer1.setName(customer.getName());
        customer1.setPhone(customer.getPhone());
        customer1.setAddress(customer.getAddress());
        list.set(idx, customer);
        return customer1;
    }
}