package com.pluralsight.example.behavioural.chainofresponsibility;

public class Part extends FileHandler {


    @Override
    void handleRequest(FileType fileType) {

        System.out.println("Part file is processing ");

    }
}
