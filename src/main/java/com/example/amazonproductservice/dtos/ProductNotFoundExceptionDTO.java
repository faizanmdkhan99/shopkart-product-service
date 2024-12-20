package com.example.amazonproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundExceptionDTO {
    Long errorCode;
    String message;
}
