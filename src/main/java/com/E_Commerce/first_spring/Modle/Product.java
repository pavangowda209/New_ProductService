package com.E_Commerce.first_spring.Modle;


import jakarta.persistence.Entity;
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
public class Product extends BasicModule{

    private String title;
    private String description;
    private String price;
    private String imageurl;
    @ManyToOne
    private Category category;
}
