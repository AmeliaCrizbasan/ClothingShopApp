package com.example.clothingshop.exception;

public class SoldOutException extends Exception{
    public SoldOutException(){
        super("Sold out!");
    }
}
