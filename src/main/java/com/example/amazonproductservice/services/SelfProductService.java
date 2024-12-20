package com.example.amazonproductservice.services;

import com.example.amazonproductservice.Projections.ProductTitleAndDescription;
import com.example.amazonproductservice.exceptions.ProductNotFoundException;
import com.example.amazonproductservice.models.Category;
import com.example.amazonproductservice.models.Product;
import com.example.amazonproductservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    ProductRepository productRepository;
    CategoryService categoryService;
    SelfProductService(ProductRepository productRepository,CategoryService categoryService){
        this.productRepository=productRepository;
        this.categoryService=categoryService;
    }

    @Override
    public Product getProductById(Long id) throws InstanceNotFoundException, ProductNotFoundException {
            return productRepository.findById(id).get();
    }
    @Override
    public ProductTitleAndDescription getProductTitleAndDescription(Long id){
        return productRepository.getProductTitleAndDescriptionSQL(id);
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllBy();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category productCategory=product.getCategory();
        if(categoryService.findCategoryByTitle(productCategory.getTitle())==null){
            Category savedCategory=categoryService.saveCategory(productCategory);
            product.setCategory(savedCategory);
        }
        else{
            Category savedCategory=categoryService.findCategoryByTitle(productCategory.getTitle());
            product.setCategory(savedCategory);
        }
        return productRepository.save(product);
    }
}
