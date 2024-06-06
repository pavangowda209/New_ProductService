package com.E_Commerce.first_spring.Controller;

import com.E_Commerce.first_spring.DTos.Product_dtos;
import com.E_Commerce.first_spring.Modle.Product;
import com.E_Commerce.first_spring.Service.Product_Interface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Product_Controller {
    // creating object of interface
    private Product_Interface productInterface;

    public Product_Controller(Product_Interface productInterface) {
        this.productInterface = productInterface;
    }


    @GetMapping("products")
    public void getallproducts(){

    }
    @GetMapping("products/{id}")
    public Product_dtos getproductbyid(@PathVariable("id") Integer id) {
        Product product = productInterface.getproductbyid(id);
        // here converting produc to productDto
        return convertproductToproductdtos(product);
    }
    // convert the product what we recieve in the fakestore product to productDto
    private Product_dtos convertproductToproductdtos(Product product) {
        Product_dtos dtos = new Product_dtos();
        dtos.setId(product.getId());
        dtos.setTitle(product.getTitle());
        dtos.setDescription(product.getDescription());
        dtos.setImageurl(product.getImageurl());
        dtos.setPrice(product.getPrice());
        dtos.setCategory(product.getCategory());
        return dtos;
    }

    @PostMapping("products")
    public void createproduct(){

    }
}
