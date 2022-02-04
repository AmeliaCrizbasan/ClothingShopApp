package com.example.clothingshop.service.impl;

import com.example.clothingshop.ClothingShopApplication;
import com.example.clothingshop.DTO.Message;
import com.example.clothingshop.DTO.Product;
import com.example.clothingshop.DTO.ProductRequest;
import com.example.clothingshop.DTO.TShirtResponse;
import com.example.clothingshop.service.ClothingShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClothingShopImpl implements ClothingShopService {
    private final ClothingShopApplication.MyGateway gateway;

    @SneakyThrows
    @Override
    public Product addTShirt(ProductRequest request) {

        Message<Object> message = new Message<>();

        Product product = new Product();
        product.setName(request.getName());
        product.setColor(request.getColor());
        product.setSize(request.getSize());
        product.setPrice(request.getPrice());


        message.setType("add");
        message.setPayload(product);

        ObjectMapper objectMapper = new ObjectMapper();

        String p = objectMapper.writeValueAsString(message);

        //trimit obiectul
        gateway.sendToMqtt(p);

//        final String uri = "http://localhost:8080/shop/add";
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Product> responseProduct = restTemplate.postForEntity(uri,product, Product.class);

        return product;
    }


    @Override
    @SneakyThrows
    public TShirtResponse buyTShirt(String name, String color, String size, Integer pieces) {

        Message<Object> message = new Message<>();

        TShirtResponse product = new TShirtResponse();
        product.setName(name);
        product.setColor(color);
        product.setSize(size);
        product.setPieces(pieces);

        message.setType("buy");
        message.setPayload(product);

        ObjectMapper objectMapper = new ObjectMapper();

        String p = objectMapper.writeValueAsString(message);

        gateway.sendToMqtt(p);

        return product;

//        final String uri = "http://localhost:8080/shop/buy/name/{name}/color/{color}/size/{size}/pieces/{pieces}";
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<TShirtResponse> response = restTemplate.getForEntity(uri, TShirtResponse.class, name, color, size, pieces);
//
//        return response.getBody();
    }
}
