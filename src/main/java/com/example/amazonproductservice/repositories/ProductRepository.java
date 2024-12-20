package com.example.amazonproductservice.repositories;

import com.example.amazonproductservice.Projections.ProductTitleAndDescription;
import com.example.amazonproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllBy();

    @Query("select p.title as title,p.description as description from products p where p.id=:id")
    ProductTitleAndDescription getProductTitleAndDescriptionHQL(@Param("id") Long id);

    @Query(value="select p.title as title,p.description as description from products p where p.id=:id",nativeQuery = true)
    ProductTitleAndDescription getProductTitleAndDescriptionSQL(@Param("id") Long id);
}
