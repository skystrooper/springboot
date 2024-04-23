package net.javaguides.springboot.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.javaguides.springboot.exceptions.CustomerNotFoundException;
import net.javaguides.springboot.exceptions.IDNotFoundException;
import net.javaguides.springboot.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {


    private final List<Customer> list = new ArrayList<Customer>();

    public List<Customer> getAllCustomers() {
        return list;
    }

    public Customer findById(int id) {
        try{
            for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }else{
                throw new IDNotFoundException("id not found");
            }
        }
        } catch (IDNotFoundException e){
            e.printStackTrace();
        }
        throw new IDNotFoundException("OOPS ID not found");
    }

    public Customer getCustomerByName(String name){
        for(int i = 0; i< list.size(); i++){
            if (list.get(i).getName().equals(name)){
                return list.get(i);
            }
        }
        throw new CustomerNotFoundException("oops customer not found");
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