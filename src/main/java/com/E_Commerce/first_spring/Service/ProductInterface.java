package com.E_Commerce.first_spring.Service;

import com.E_Commerce.first_spring.Modle.Product;

import java.util.List;

public interface ProductInterface {
    Product getproductbyid(Integer id);
    List<Product> getallproducts();
    Product createproduct(String title,String description,String image,double price,String category);
}
