package com.pluralsight.example.behavioural.chainofresponsibility;

public abstract class FileHandler {

    FileHandler fileHandler;

    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    abstract void handleRequest(FileType fileType);
}
