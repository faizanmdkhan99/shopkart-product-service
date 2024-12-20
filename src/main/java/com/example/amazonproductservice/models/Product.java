package com.example.amazonproductservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    String description;
    @ManyToOne(cascade = CascadeType.DETACH)
    Category category;
    Double price;
}
