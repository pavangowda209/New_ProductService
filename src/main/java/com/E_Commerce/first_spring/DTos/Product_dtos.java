package com.E_Commerce.first_spring.DTos;

import com.E_Commerce.first_spring.Modle.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Product_dtos {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageurl;
    private Category category;
}
