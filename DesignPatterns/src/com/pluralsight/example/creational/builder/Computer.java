package com.pluralsight.example.creational.builder;

public class Computer {

    private final String name;

    private final String type;

    public static class ComputerBuilder {
        private String name;

        private String type;

        public ComputerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ComputerBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public Computer(ComputerBuilder computerBuilder) {
        this.name = computerBuilder.name;
        this.type = computerBuilder.type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
