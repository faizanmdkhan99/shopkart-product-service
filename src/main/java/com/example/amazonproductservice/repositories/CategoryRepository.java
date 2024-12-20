package com.example.amazonproductservice.repositories;

import com.example.amazonproductservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("select c from category c where c.title = :title")
    Category getCategoryByTitle(@Param("title") String  title);
}
