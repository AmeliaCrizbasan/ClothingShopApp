package com.example.clothingshop.service;

import com.example.clothingshop.DTO.*;
import com.example.clothingshop.exception.SoldOutException;

public interface ClothingShopService {
    Product addTShirt(ProductRequest request);
    TShirtResponse buyTShirt(String name, String color, String size, Integer pieces);
}
