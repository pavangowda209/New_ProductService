package com.E_Commerce.first_spring.Modle;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
public class Category extends BasicModule{
    private String name;
}
