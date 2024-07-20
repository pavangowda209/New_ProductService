package com.E_Commerce.first_spring.Service;

import com.E_Commerce.first_spring.DTos.Product_dtos;
import com.E_Commerce.first_spring.Exceptions.CategoryNotFoundExceptions;
import com.E_Commerce.first_spring.Modle.Category;
import com.E_Commerce.first_spring.Modle.Product;
import com.E_Commerce.first_spring.Repository.CategoryRepository;
import com.E_Commerce.first_spring.Repository.ProductRepository;
import com.E_Commerce.first_spring.Repository.Projections.ProductWithIdandTitle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Category> fetchedcategory=categoryRepository.findByName(category);
        if(fetchedcategory.isEmpty()) {
            throw new CategoryNotFoundExceptions("category is not found  or not created upto now ");
        }
        Product producttoBesaved = new Product();
        producttoBesaved.setTitle(title);
        producttoBesaved.setDescription(description);
        producttoBesaved.setImageurl(image);
        producttoBesaved.setPrice(String.valueOf(price));
        producttoBesaved.setCategory(fetchedcategory.get());
        Product updatedproduct = productRepository.save(producttoBesaved);
       // List<ProductWithIdandTitle> list = productRepository.gettitleandidbyusingprice("109.21");
        //convertprojectionTodto(list);
        return updatedproduct;
    }

    @Override
    public Page<Product> getpaginated(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Product> prd = productRepository.findAll(pageable);
        return prd;
    }

    private void convertprojectionTodto(List<ProductWithIdandTitle> list) {
        Product_dtos ans = new Product_dtos();
        ProductWithIdandTitle pt = list.get(0);
        if(pt.getTitle() != null) {
            ans.setTitle(pt.getTitle());
        }
        if(pt.getId() != null) {
            ans.setId(pt.getId());
        }
    }
}
