package com.example.amazonproductservice.controllers;

import com.example.amazonproductservice.Projections.ProductTitleAndDescription;
import com.example.amazonproductservice.dtos.ProductDTO;
import com.example.amazonproductservice.dtos.ProductNotFoundExceptionDTO;
import com.example.amazonproductservice.exceptions.ProductNotFoundException;
import com.example.amazonproductservice.models.Product;
import com.example.amazonproductservice.services.ProductService;
import com.example.amazonproductservice.services.TokenService;
import org.hibernate.cache.spi.access.UnknownAccessTypeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final TokenService tokenService;
    ProductService productService;
    public ProductController(@Qualifier("SelfProductService") ProductService productService, TokenService tokenService){
        this.productService=productService;
        this.tokenService = tokenService;
    }
    @GetMapping("/{id}")
    public ProductDTO getProductById(
//            @RequestHeader("Token") String token,
            @PathVariable("id") Long id)
            throws ProductNotFoundException, InstanceNotFoundException {
//        if(!tokenService.validateToken(token)){
//            throw new InstanceNotFoundException("User is not authorized");
//        }
        Product product=productService.getProductById(id);
        if(product==null){
            return new ProductDTO();
        }
        return ProductDTO.convertFromProduct(product);
    }
    @GetMapping()
    public List<ProductDTO> getAllProducts(){
        List<ProductDTO> productDTOList=new ArrayList<>();
        List<Product> products=productService.getAllProducts();
        for(Product p: products){
            productDTOList.add(ProductDTO.convertFromProduct(p));
        }
        return productDTOList;
    }



    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.replaceProduct(id,product);
    }

    @PostMapping()
        public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

//    @GetMapping("/{id}")
//    public ProductTitleAndDescription getProductTitleAndDescription(@PathVariable("id") Long id){
//        return productService.getProductTitleAndDescription(id);
//    }
}

