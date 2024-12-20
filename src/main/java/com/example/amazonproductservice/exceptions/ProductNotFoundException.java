package com.example.amazonproductservice.exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends Exception{
    Long id;
    public ProductNotFoundException(Long id,String message){
        super(message);
        this.id=id;
    }
}
