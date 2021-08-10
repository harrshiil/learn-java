package com.pluralsight.example.behavioural.chainofresponsibility;

public class Rev extends FileHandler {


    @Override
    void handleRequest(FileType fileType) {
        if (fileType.equals(FileType.REV)) {
            System.out.println("Rev file is processing ");
        } else {
            fileHandler.handleRequest(fileType);
        }
    }
}
