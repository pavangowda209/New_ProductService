package com.E_Commerce.first_spring.DTos;

import com.E_Commerce.first_spring.Models.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class Product_dtos implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageurl;
    private Category category;
}
