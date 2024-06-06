package com.E_Commerce.first_spring.Modle;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageurl;
    private Category category;
}
