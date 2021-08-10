package com.pluralsight.example.creational.factory;

import java.util.LinkedList;
import java.util.List;

public abstract class Website {
    List<String> pages = new LinkedList<>();

    public Website() {
        createPages();
    }

    public abstract void createPages();

    public List<String> getPages() {
        return pages;
    }
}
