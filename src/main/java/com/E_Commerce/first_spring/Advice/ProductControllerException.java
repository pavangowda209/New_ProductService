package com.E_Commerce.first_spring.Advice;

import com.E_Commerce.first_spring.DTos.ErrorDtos;
import com.E_Commerce.first_spring.Exceptions.CategoryNotFoundExceptions;
import com.E_Commerce.first_spring.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerException {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDtos> handleproductException(ProductNotFoundException exception) {
        ErrorDtos errorDtos = new ErrorDtos();
        errorDtos.setCode("Status_code");
        errorDtos.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorDtos, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CategoryNotFoundExceptions.class)
    public ResponseEntity<ErrorDtos> handlecategoryException(CategoryNotFoundExceptions exception) {
        ErrorDtos errorDtos = new ErrorDtos();
        errorDtos.setCode("Status_code");
        errorDtos.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorDtos, HttpStatus.NOT_FOUND);
    }
}
