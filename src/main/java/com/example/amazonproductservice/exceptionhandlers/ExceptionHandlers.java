package com.example.amazonproductservice.exceptionhandlers;

import com.example.amazonproductservice.dtos.ProductNotFoundExceptionDTO;
import com.example.amazonproductservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> handleInstanceNotFoundException(ProductNotFoundException exception) {
        ProductNotFoundExceptionDTO productNotFoundExceptionDto = new ProductNotFoundExceptionDTO();
        productNotFoundExceptionDto.setErrorCode(exception.getId());
        productNotFoundExceptionDto.setMessage(exception.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> handleNullException(ProductNotFoundException exception) {
        ProductNotFoundExceptionDTO productNotFoundExceptionDto = new ProductNotFoundExceptionDTO();
        productNotFoundExceptionDto.setErrorCode(exception.getId());
        productNotFoundExceptionDto.setMessage(exception.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto, HttpStatus.NOT_FOUND);
    }
}
