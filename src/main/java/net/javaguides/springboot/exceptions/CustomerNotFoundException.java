package net.javaguides.springboot.exceptions;

import net.javaguides.springboot.model.Customer;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){
        super(message);
    }
}

