package net.javaguides.springboot.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorObjects  {
    private Integer statusCode;
    private String message;

}
