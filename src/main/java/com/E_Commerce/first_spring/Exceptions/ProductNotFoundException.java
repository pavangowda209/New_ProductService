package com.E_Commerce.first_spring.Exceptions;


public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message) {
        super(message);
    }

}
