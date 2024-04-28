package net.javaguides.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handlesMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldname = ((FieldError)error).getField();

            String message = error.getDefaultMessage();

            resp.put(fieldname,message);
        });
        return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
    }
}
