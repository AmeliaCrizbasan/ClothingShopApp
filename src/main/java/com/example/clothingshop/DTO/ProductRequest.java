package com.example.clothingshop.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private Double price;
    private String color;
    private String size;
}

