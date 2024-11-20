package com.E_Commerce.first_spring.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Product extends BaseModel{

    private String title;
    private String description;
    private String price;
    private String imageUrl;
    @ManyToOne(cascade = {CascadeType.REMOVE})
    private Category category;
}
