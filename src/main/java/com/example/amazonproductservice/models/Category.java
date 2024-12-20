package com.example.amazonproductservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// We will create the category as a class and not an enum because we might add more attributes later on. Also if we want to add a new category, in case of enum we will have to restart the application but a class doesn't require any restart
@Entity(name="category")
public class Category extends  BaseModel{
    String description;
}
