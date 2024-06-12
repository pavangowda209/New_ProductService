package com.E_Commerce.first_spring.Modle;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
public class Category extends BasicModel{

    private String name;
    // Here implement the cardinality

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
