package com.example.amazonproductservice.services;

import com.example.amazonproductservice.Projections.ProductTitleAndDescription;
import com.example.amazonproductservice.dtos.FakeStoreProductDTO;
import com.example.amazonproductservice.exceptions.ProductNotFoundException;
import com.example.amazonproductservice.models.Category;
import com.example.amazonproductservice.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreService")
public class FakeStoreProductService implements ProductService{
    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    public Product getProductById(Long id) throws ProductNotFoundException {
        FakeStoreProductDTO fakeStoreProductDTO=restTemplate.getForObject
                ("https://fakestoreapi.com/products/"+id,FakeStoreProductDTO.class);
        if(fakeStoreProductDTO==null){
            throw new ProductNotFoundException(101L,"Product not found for id "+id);
        }
        return convertToProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOS=restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);
        List<Product> products=new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO:fakeStoreProductDTOS){
            products.add(convertToProduct(fakeStoreProductDTO));
        }
        return products;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setDescription(product.getDescription());
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTO,FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO1=
                restTemplate
                        .execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor)
                        .getBody();
        return convertToProduct(fakeStoreProductDTO1);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public ProductTitleAndDescription getProductTitleAndDescription(Long id) {
        return null;
    }



    public Product convertToProduct(FakeStoreProductDTO fakeStoreProductDTO){
        if(fakeStoreProductDTO==null){
            return null;
        }
        Product product=new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        Category category=new Category();
        category.setTitle(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }
}
