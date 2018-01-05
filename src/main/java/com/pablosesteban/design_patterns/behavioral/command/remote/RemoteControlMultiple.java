/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.command.remote;

import com.pablosesteban.design_patterns.behavioral.command.Command;
import com.pablosesteban.design_patterns.behavioral.command.CommandDefault;
import com.pablosesteban.design_patterns.behavioral.command.CommandDoorClose;
import com.pablosesteban.design_patterns.behavioral.command.CommandDoorOpen;
import com.pablosesteban.design_patterns.behavioral.command.CommandLightOff;
import com.pablosesteban.design_patterns.behavioral.command.CommandLightOn;
import com.pablosesteban.design_patterns.behavioral.command.CommandMacro;
import com.pablosesteban.design_patterns.behavioral.command.device.DoorGarage;
import com.pablosesteban.design_patterns.behavioral.command.device.LightKitchen;
import com.pablosesteban.design_patterns.behavioral.command.device.LightLivingRoom;
import java.util.Stack;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: COMMAND
    give us a way to package a piece of computation (a receiver and a set of actions) and pass it around as a first-class object

    it is used when you need to decouple an object making requests from the objects that know how to perform the requests

    can be used to queuing request (web servers) or loggin request
*/

// this time around the remote is going to handle several ON and OFF commands
public class RemoteControlMultiple {
    private Command[] onCommands;
    private Command[] offCommands;
    /*
    in order ot implement a history of undo operations, i.e. to be able to press the undo button multiple times
    
    instead of keeping just a reference to the last Command executed, keeping a stack of previous Commands
    */
    private Stack<Command> undoCommand;
    
    public RemoteControlMultiple(int devices) {
        onCommands = new Command[devices];
        
        offCommands = new Command[devices];
        
        // in order not to deal with a NullPointerException when there are empty slots
        CommandDefault commandDefault = new CommandDefault();
        for (int i = 0; i < devices; i++) {
            onCommands[i] = commandDefault;
            
            offCommands[i] = commandDefault;
        }
        
        undoCommand = new Stack<>();
        // not really needed but to use the Null Object "design pattern"
        undoCommand.push(commandDefault);
    }
    
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        
        offCommands[slot] = offCommand;
    }
    
    public void onButtonPressed(int slot) {
        onCommands[slot].execute();
        
        undoCommand.push(onCommands[slot]);
    }
    
    public void offButtonPressed(int slot) {
        offCommands[slot].execute();
        
        undoCommand.push(offCommands[slot]);
    }
    
    public void undoButtonPressed() {
        if (!undoCommand.isEmpty()) {
            undoCommand.pop().undo();
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("RemoteControlMultiple{\n");
        int i = 0;
        for (; i < onCommands.length; i++) {
            sb.append("\t[slot ");
            sb.append(i);
            sb.append("] ON=");
            sb.append(onCommands[i]);
            sb.append(", OFF=");
            sb.append(offCommands[i]);
            sb.append("\n");
        }
        
        sb.append("\t[slot ");
        sb.append(i);
        sb.append("] UNDO=");
        sb.append(undoCommand);
        sb.append("\n}");
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        RemoteControlMultiple remoteControlMultiple = new RemoteControlMultiple(5);
        
        DoorGarage doorGarage = new DoorGarage();
        CommandDoorOpen commandDoorGarageOpen = new CommandDoorOpen();
        commandDoorGarageOpen.setDoor(doorGarage);
        CommandDoorClose commandDoorGrarageClose = new CommandDoorClose();
        commandDoorGrarageClose.setDoor(doorGarage);
        
        LightKitchen lightKitchen = new LightKitchen();
        CommandLightOn commandLightKitchenOn = new CommandLightOn();
        commandLightKitchenOn.setLight(lightKitchen);
        CommandLightOff commandLightKitchenOff = new CommandLightOff(lightKitchen);
        
        LightLivingRoom lightLivingRoom = new LightLivingRoom();
        CommandLightOn commandLightLivingRoomOn = new CommandLightOn();
        commandLightLivingRoomOn.setLight(lightLivingRoom);
        CommandLightOff commandLightLivingRoomOff = new CommandLightOff(lightLivingRoom);
        
        CommandMacro commandMacroOn = new CommandMacro(new Command[]{commandLightKitchenOn, commandDoorGarageOpen, commandLightLivingRoomOn});
        CommandMacro commandMacroOff = new CommandMacro(new Command[]{commandLightKitchenOff, commandDoorGrarageClose, commandLightLivingRoomOff});
        
        remoteControlMultiple.setCommand(0, commandLightKitchenOn, commandLightKitchenOff);
        remoteControlMultiple.setCommand(1, commandDoorGarageOpen, commandDoorGrarageClose);
        remoteControlMultiple.setCommand(2, commandLightLivingRoomOn, commandLightLivingRoomOff);
        remoteControlMultiple.setCommand(3, commandMacroOn, commandMacroOff);
        
        System.out.println(remoteControlMultiple);
        
        System.out.print("SLOT 2 ON: ");
        remoteControlMultiple.onButtonPressed(2);
        
        System.out.print("SLOT 1 OFF: ");
        remoteControlMultiple.offButtonPressed(1);
        
        System.out.print("SLOT UNDO: ");
        remoteControlMultiple.undoButtonPressed();
        
        System.out.print("SLOT UNDO: ");
        remoteControlMultiple.undoButtonPressed();
        
        System.out.print("SLOT 0 OFF: ");
        remoteControlMultiple.offButtonPressed(0);
        
        System.out.print("SLOT 3 ON: ");
        remoteControlMultiple.onButtonPressed(3);
        
        System.out.print("SLOT UNDO: ");
        remoteControlMultiple.undoButtonPressed();
        
        System.out.print("SLOT UNDO: ");
        remoteControlMultiple.undoButtonPressed();
        
        System.out.print("SLOT UNDO: ");
        remoteControlMultiple.undoButtonPressed();
        
        System.out.println("");
        
        System.out.println(remoteControlMultiple);
    }
}
