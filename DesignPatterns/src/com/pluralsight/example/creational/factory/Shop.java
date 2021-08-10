package com.pluralsight.example.creational.factory;

public class Shop extends Website {
    @Override
    public void createPages() {
        pages.add("Item Pages");
        pages.add("Cart Pages");
    }
}
