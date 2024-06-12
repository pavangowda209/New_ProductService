package com.E_Commerce.first_spring.Repository;

import com.E_Commerce.first_spring.Modle.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByName(String name);
}
