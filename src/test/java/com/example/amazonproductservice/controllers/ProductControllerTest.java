package com.example.amazonproductservice.controllers;

import com.example.amazonproductservice.exceptions.ProductNotFoundException;
import com.example.amazonproductservice.models.Product;
import com.example.amazonproductservice.repositories.ProductRepository;
import com.example.amazonproductservice.services.ProductService;
import org.hibernate.cache.spi.access.UnknownAccessTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.management.InstanceNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    ProductController productController;

    @MockBean(name="SelfProductService")
    ProductService productService;
    @Autowired
    private ProductRepository productRepository;

//    @Test
//    void getProductById() throws InstanceNotFoundException, ProductNotFoundException, UnknownAccessTypeException {
//        Product product=new Product();
//        product.setId(1L);
//        product.setTitle("test");
//        product.setPrice(100.00);
//
//
//        when(productService.getProductById(1L)).thenReturn(product);
//
////        Product p=productController.getProductById(1L).getBody();
//
////        Assertions.assertEquals("test",p.getTitle());
//
//    }

//    @Test
//    void getProductByIdThrowsException() throws InstanceNotFoundException, ProductNotFoundException {
//        Product product=new Product();
//        product.setTitle("Test");
//        product.setId(1L);
//        product.setPrice(200.0);
//
//        when(productService.getProductById(1L)).thenThrow(ProductNotFoundException.class);
//
//        Assertions.assertThrows(ProductNotFoundException.class,()->productController.getProductById(1L));
//    }
}