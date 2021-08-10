package com.pluralsight.example.creational.builder;

public class ComputerBuilderDemo {

    public static void main(String[] args) {
        Computer.ComputerBuilder computerBuilder = new Computer.ComputerBuilder();
        Computer computer = computerBuilder.name("ABC")
                .type("Desktop")
                .build();
        System.out.println(computer.getName() + " = " + computer.getType());
    }


}
