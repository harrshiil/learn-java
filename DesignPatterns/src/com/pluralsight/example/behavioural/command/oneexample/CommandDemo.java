package com.pluralsight.example.behavioural.command.oneexample;

public class CommandDemo {

    public static void main(String[] args) {
        Light kitchenLight = new Light();  // Reciever
        Switch lightSwitch = new Switch();   // Invoker

        Command togggleCommand = new ToggleCommand(kitchenLight); // Concrete Command

        lightSwitch.executeCommand(togggleCommand);
        lightSwitch.executeCommand(togggleCommand);
    }
}
