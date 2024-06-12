package com.E_Commerce.first_spring.Modle;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
public class Product extends BasicModel{

    private String title;
    private String description;
    private String price;
    private String imageurl;

    // here implement the cascade type
    @ManyToOne(cascade = {CascadeType.REMOVE})
    private Category category;
}
