package com.E_Commerce.first_spring.Repository;

import com.E_Commerce.first_spring.Modle.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    //Creating  Products
    Product save(Product p);

    // Getting list of products
    List<Product> findAll();

    //Getting product by id
    Product findProductByid(Integer id);

}
