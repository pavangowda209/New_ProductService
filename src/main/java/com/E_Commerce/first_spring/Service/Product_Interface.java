package com.E_Commerce.first_spring.Service;

import com.E_Commerce.first_spring.Modle.Product;

public interface Product_Interface {
    Product getproductbyid(Integer id);
    Product getallproducts();
    Product createproduct(String title,String description,String image,double price,String category);
}
