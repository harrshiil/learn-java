package com.pluralsight.example.creational.factory;

public class WebsiteFactoryDemo {

    public static void main(String[] args) {

        Website website = WebsiteFactory.createWebsite(WebsiteType.BLOG);

        System.out.println(website.getPages());


        Website website2 = WebsiteFactory.createWebsite(WebsiteType.SHOP);

        System.out.println(website2.getPages());
    }
}
