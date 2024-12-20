package com.example.amazonproductservice.dtos;

import com.example.amazonproductservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    String title;
    double price;
    String category;
    String description;
    public static ProductDTO convertFromProduct(Product product){
        ProductDTO productDTO=new ProductDTO();
        productDTO.setTitle(product.getTitle());
        productDTO.setCategory(product.getCategory().getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

}

