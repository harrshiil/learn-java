package com.pluralsight.example.creational.factory;

public class WebsiteFactory {

    public static Website createWebsite(WebsiteType websiteType) {
        switch (websiteType) {
            case BLOG:
                return new Blog();
            case SHOP:
                return new Shop();
            default:
                return null;
        }
    }
}
