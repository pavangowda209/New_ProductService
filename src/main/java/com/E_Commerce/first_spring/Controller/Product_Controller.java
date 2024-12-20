package com.E_Commerce.first_spring.Controller;


import com.E_Commerce.first_spring.DTos.CreateProduct_dto;
import com.E_Commerce.first_spring.DTos.Fakestore_ProductDTOs;
import com.E_Commerce.first_spring.DTos.Product_dtos;
import com.E_Commerce.first_spring.Exceptions.CategoryNotFoundExceptions;
import com.E_Commerce.first_spring.Exceptions.ProductNotFoundException;
import com.E_Commerce.first_spring.Models.Product;
import com.E_Commerce.first_spring.Service.ProductInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Product_Controller {
    // creating object of interface
    private ProductInterface productInterface;
    // Constructor
    public Product_Controller(@Qualifier("selfProductService") ProductInterface productInterface) {
        this.productInterface = productInterface;
    }

    // **Getting all products from the service layer..**
    @GetMapping("/allproducts")
    public List<Product_dtos> getallproducts() {
        List<Product_dtos> list = new ArrayList<>();
        List<Product>products = productInterface.getallproducts();
        for(Product p : products) {
            list.add(convertproductToproductdtos(p));
        }

        return list;
    }

    // Returning product by required Id
    @Cacheable(value = "product")
    @GetMapping("/products/{id}")
    public Product_dtos getproductbyid(@PathVariable("id") Integer id) throws ProductNotFoundException {
        Product product = productInterface.getproductbyid(id);
        if(product == null) {
            throw new ProductNotFoundException("product is not found");
        }
        // here converting produc to productDto
        return convertproductToproductdtos(product);
    }
    // convert the product what we recieve in the fakestore product to productDto

    private Product_dtos convertproductToproductdtos(Product product) {
        Product_dtos dtos = new Product_dtos();
        dtos.setId(product.getId());
        dtos.setTitle(product.getTitle());
        dtos.setDescription(product.getDescription());
        dtos.setImageurl(product.getImageUrl());
        dtos.setPrice(product.getPrice());
        dtos.setCategory(product.getCategory());
        return dtos;
    }

    // Creating Products in the Fakestore products service
    @CachePut(value = "product",key = "#dto.title")
    @PostMapping("/create")
    public Product createproducts(@RequestBody CreateProduct_dto dto) throws CategoryNotFoundExceptions {
        Product p = productInterface.createproduct(dto.getTitle(),
                dto.getDescription(),
                dto.getImage(),
                dto.getPrice(),
                dto.getCategory());
        return p;
    }
    @GetMapping("/page/{pageNo}/{pageSize}")
    public ResponseEntity<List<Product>> getpaginated(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize) {
        Page<Product> paginated = productInterface.getpaginated(pageNo,pageSize);
        System.out.println("paginated:" + paginated);
        return ResponseEntity.ok(paginated.getContent());
    }
    @GetMapping("/products/category/{categoryname}")
    public List<Product_dtos> getCategoryByName(@PathVariable("category") String categoryName) {
        List<Product>products = productInterface.getCategoryBycategoryname(categoryName);
        List<Product_dtos> dtOs = new ArrayList<>();
        for (Product p : products) {
            dtOs.add(convertproductToproductdtos(p));
        }
        return dtOs;
    }
    @DeleteMapping("/products/{Id}")
    public Product_dtos deleteproductById(@PathVariable("Id") Integer Id) {
        Product p = productInterface.deleteProductbyId(Id);
        return convertproductToproductdtos(p);
    }
}
