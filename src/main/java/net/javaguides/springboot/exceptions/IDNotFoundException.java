package net.javaguides.springboot.exceptions;

public class IDNotFoundException extends RuntimeException{
    
    public IDNotFoundException(String message){
        super(message);
    }
}
