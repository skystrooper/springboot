package net.javaguides.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorObjects> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request){
        ErrorObjects errorObjects = new ErrorObjects();

        errorObjects.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObjects.setMessage(ex.getMessage());

        return new ResponseEntity<ErrorObjects>(errorObjects, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ErrorObjects> handleIDNotFoundException(IDNotFoundException ex, WebRequest request){
        ErrorObjects errorObjects = new ErrorObjects();

        errorObjects.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObjects.setMessage(ex.getMessage());

        return new ResponseEntity<ErrorObjects>(errorObjects,HttpStatus.NOT_FOUND);
    }
}
