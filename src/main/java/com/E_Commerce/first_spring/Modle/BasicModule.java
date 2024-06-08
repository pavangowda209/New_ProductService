package com.E_Commerce.first_spring.Modle;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BasicModule {
    @Id
    private Integer id;
    private Date updatedAt;
    private Date createdAt;

}
