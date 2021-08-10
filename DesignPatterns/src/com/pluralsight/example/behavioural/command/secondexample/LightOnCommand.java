package com.pluralsight.example.behavioural.command.secondexample;

class LightOnCommand implements Command {
    private Light myLight;

    public LightOnCommand(Light L) {
        myLight = L;
    }

    @Override
    public void execute() {
        myLight.turnOn();
    }
}