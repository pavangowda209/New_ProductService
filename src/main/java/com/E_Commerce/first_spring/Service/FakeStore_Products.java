package com.E_Commerce.first_spring.Service;


import com.E_Commerce.first_spring.DTos.Fakestore_ProductDTOs;
import com.E_Commerce.first_spring.Modle.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStore_Products implements Product_Interface {

    private RestTemplate restTemplate;

    public FakeStore_Products(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getproductbyid(Integer id) {
        ResponseEntity<Fakestore_ProductDTOs> response = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                Fakestore_ProductDTOs.class);
        Fakestore_ProductDTOs fakestoreProductDTOs = response.getBody();
        return fakestoreProductDTOs.ToProduct();
    }

    @Override
    public Product getallproducts() {
        return null;
    }

    @Override
    public Product createproduct() {

        return null;
    }

}
