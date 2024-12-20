package com.example.amazonproductservice.services;


import com.example.amazonproductservice.Projections.ProductTitleAndDescription;
import com.example.amazonproductservice.exceptions.ProductNotFoundException;
import com.example.amazonproductservice.models.Product;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.List;
@Service
public interface ProductService {
    Product getProductById(Long id) throws InstanceNotFoundException, ProductNotFoundException;

    List<Product> getAllProducts();

    Product replaceProduct(Long id, Product product);

    Product createProduct(Product product);

    ProductTitleAndDescription getProductTitleAndDescription(Long id);


}
