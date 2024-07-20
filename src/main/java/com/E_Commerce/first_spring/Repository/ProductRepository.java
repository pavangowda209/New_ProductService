package com.E_Commerce.first_spring.Repository;

import com.E_Commerce.first_spring.Modle.Product;
import com.E_Commerce.first_spring.Repository.Projections.ProductWithIdandTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    //Creating  Products
    Product save(Product p);

    // Getting list of products
    List<Product> findAll();

    //Getting product by id
    Product findProductByid(Integer id);

    // Getting product by title and id
    @Query("select p from Product p where p.id = :id and p.title = :title")
    Product getproductbytitleandid(@Param("title") String title, @Param("id") Integer id);

    // Getting all products of title and id by using price
    @Query("select p.title,p.id from  Product p where p.price = :price")
    List<ProductWithIdandTitle> gettitleandidbyusingprice(@Param("price") String price);


    // my own query = MYSQL
    @Query(nativeQuery = true,value = "select * from product where id = :id")
    Product myownsqlquery(Integer id);

}
