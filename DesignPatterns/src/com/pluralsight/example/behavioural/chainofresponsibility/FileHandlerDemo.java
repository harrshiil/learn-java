package com.pluralsight.example.behavioural.chainofresponsibility;

public class FileHandlerDemo {

    public static void main(String[] args) {
        Rev rev = new Rev();
        Part part = new Part();

        rev.setFileHandler(part);

        rev.handleRequest(FileType.REV);
        rev.handleRequest(FileType.PART);
    }
}
