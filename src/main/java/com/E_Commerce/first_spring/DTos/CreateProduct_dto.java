package com.E_Commerce.first_spring.DTos;


import com.E_Commerce.first_spring.Modle.Category;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class CreateProduct_dto {
    String title;
    Double price;
    String description;
    String image;
    String category;
}
