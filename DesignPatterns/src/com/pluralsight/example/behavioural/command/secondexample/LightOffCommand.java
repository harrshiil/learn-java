package com.pluralsight.example.behavioural.command.secondexample;

class LightOffCommand implements Command {
    private Light myLight;

    public LightOffCommand(Light L) {
        myLight = L;
    }

    @Override
    public void execute() {
        myLight.turnOff();
    }
}