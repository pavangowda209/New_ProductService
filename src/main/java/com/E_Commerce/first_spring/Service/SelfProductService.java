package com.E_Commerce.first_spring.Service;

import com.E_Commerce.first_spring.Exceptions.CategoryNotFoundExceptions;
import com.E_Commerce.first_spring.Modle.Category;
import com.E_Commerce.first_spring.Modle.Product;
import com.E_Commerce.first_spring.Repository.CategoryRepository;
import com.E_Commerce.first_spring.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductInterface{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getproductbyid(Integer id) {

        return productRepository.findProductByid(id);
    }

    @Override
    public List<Product> getallproducts() {

        return productRepository.findAll();
    }

    @Override
    public Product createproduct(String title, String description, String image, double price, String category) throws CategoryNotFoundExceptions {
        Category fetchedcategory=categoryRepository.findByName(category);
        if(fetchedcategory == null) {
            throw new CategoryNotFoundExceptions("category is not found  or not created upto now ");
        }
        Product producttoBesaved = new Product();
        producttoBesaved.setTitle(title);
        producttoBesaved.setDescription(description);
        producttoBesaved.setImageurl(image);
        producttoBesaved.setPrice(String.valueOf(price));
        producttoBesaved.setCategory(fetchedcategory);
        Product updatedproduct = productRepository.save(producttoBesaved);

        return updatedproduct;
    }

}
