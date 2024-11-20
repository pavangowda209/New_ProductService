package com.E_Commerce.first_spring.DTos;

import com.E_Commerce.first_spring.Models.Category;
import com.E_Commerce.first_spring.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fakestore_ProductDTOs {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;

    public Product ToProduct() {
        Product p = new Product();
        p.setId(id);
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageUrl(image);

        Category c = new Category();
        c.setName(category);
        p.setCategory(c);
        return p;
    }
}
