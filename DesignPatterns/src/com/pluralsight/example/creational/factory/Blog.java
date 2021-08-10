package com.pluralsight.example.creational.factory;

public class Blog extends Website {
    @Override
    public void createPages() {
        pages.add("Search Pages");
        pages.add("About Pages");
    }
}
