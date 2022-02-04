package com.example.clothingshop.controller;

import com.example.clothingshop.DTO.Product;
import com.example.clothingshop.DTO.ProductRequest;
import com.example.clothingshop.DTO.TShirtResponse;
import com.example.clothingshop.service.ClothingShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/clothingShop")
public class ClothingShopController {

    private final ClothingShopService clothingShopService;

    public ClothingShopController(ClothingShopService clothingShopService) {
        this.clothingShopService = clothingShopService;
    }

    @PostMapping(path = "/addT-Shirt")
    public ResponseEntity<Product> addTShirt(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(clothingShopService.addTShirt(request), HttpStatus.OK);
    }

    @GetMapping(path = "/buyT-Shirt/name/{name}/color/{color}/size/{size}/pieces/{pieces}")
    public ResponseEntity<TShirtResponse> buyTShirt(@PathVariable("name") String name,
                                                    @PathVariable("color") String color,
                                                    @PathVariable("size") String size,
                                                    @PathVariable("pieces") Integer pieces) {
        TShirtResponse response = clothingShopService.buyTShirt(name, color, size, pieces);

        // return new ResponseEntity<>(response, HttpStatus.OK);
        // if (response.getMessage().equals("Buy")) {
        return new ResponseEntity<>(response, HttpStatus.OK);
        // } else {
        //   return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        // }
    }
//        if (response.getMessage().equals("Buy")) {
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } else {
//            throw new SoldOutException();
//
//        }

}
