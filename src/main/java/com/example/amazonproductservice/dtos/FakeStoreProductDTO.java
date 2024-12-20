package com.example.amazonproductservice.dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FakeStoreProductDTO {
    Long id;
    String title;
    double price;
    String category;
    String description;
}
