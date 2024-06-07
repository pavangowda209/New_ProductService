package com.E_Commerce.first_spring.Controller;

import com.E_Commerce.first_spring.DTos.CreateProduct_dto;
import com.E_Commerce.first_spring.DTos.Product_dtos;
import com.E_Commerce.first_spring.Exceptions.ProductNotFoundException;
import com.E_Commerce.first_spring.Modle.Product;
import com.E_Commerce.first_spring.Service.ProductInterface;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Product_Controller {
    // creating object of interface
    private ProductInterface productInterface;

    public Product_Controller(ProductInterface productInterface) {
        this.productInterface = productInterface;
    }

    @GetMapping("/products")
    public List<Product_dtos> getallproducts() {
        List<Product_dtos> list = new ArrayList<>();
        List<Product>products = productInterface.getallproducts();
        for(Product p : products) {
            list.add(convertproductToproductdtos(p));
        }

        return list;
    }
    @GetMapping("/products/{id}")
    public Product_dtos getproductbyid(@PathVariable("id") Integer id) throws ProductNotFoundException {
        Product product = productInterface.getproductbyid(id);
        if(product == null) {
            throw new ProductNotFoundException("product is not found");
        }
        // here converting produc to productDto
        Product_dtos response = convertproductToproductdtos(product);
        return response;
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
    @PostMapping("/products")
    public Product createproduct(@RequestBody CreateProduct_dto dto) {
        Product p = productInterface.createproduct(dto.getTitle(),
                dto.getDescription(),
                dto.getImage(),
                dto.getPrice(),
                dto.getCategory());
        return p;
    }
}
