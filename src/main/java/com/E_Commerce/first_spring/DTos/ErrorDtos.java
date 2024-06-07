package com.E_Commerce.first_spring.DTos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDtos {
    String message;
    String code;
}
