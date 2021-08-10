package com.pluralsight.example.behavioural.command.oneexample;

public class ToggleCommand implements Command {

    private Light light;

    public ToggleCommand(Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.toggle();
    }
}
