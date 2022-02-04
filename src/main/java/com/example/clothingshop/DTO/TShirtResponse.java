package com.example.clothingshop.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TShirtResponse {
   private String name;
    private String color;
    private String size;
    private Integer pieces;
}
