package com.pluralsight.example.behavioural.command.secondexample;

public class TestCommand {
    public static void main(String[] args) {
        Light testLight = new Light();
        LightOnCommand testLOC = new LightOnCommand(testLight);
        LightOffCommand testLFC = new LightOffCommand(testLight);
        Switch testSwitch = new Switch(testLOC, testLFC);
        testSwitch.flipUp();
        testSwitch.flipDown();
    }
}