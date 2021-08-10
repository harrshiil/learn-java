package com.pluralsight.example.behavioural.command.oneexample;

public class Light {

    private boolean isOn = true;

    public void toggle() {
        if (isOn) {
            on();
            isOn = false;
        } else {
            off();
            isOn = true;
        }
    }

    private void on() {
        System.out.println("Light  Switched on.");
    }

    private void off() {
        System.out.println("Light  Switched off.");
    }
}
