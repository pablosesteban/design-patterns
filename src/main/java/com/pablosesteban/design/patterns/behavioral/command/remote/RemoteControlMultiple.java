/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.command.remote;

import com.pablosesteban.design.patterns.behavioral.command.Command;
import com.pablosesteban.design.patterns.behavioral.command.CommandDoorClose;
import com.pablosesteban.design.patterns.behavioral.command.CommandDoorOpen;
import com.pablosesteban.design.patterns.behavioral.command.CommandLightOff;
import com.pablosesteban.design.patterns.behavioral.command.CommandLightOn;
import com.pablosesteban.design.patterns.behavioral.command.device.DoorGarage;
import com.pablosesteban.design.patterns.behavioral.command.device.LightKitchen;
import com.pablosesteban.design.patterns.behavioral.command.device.LightLivingRoom;
import java.util.Arrays;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

// this time around the remote is going to handle several ON and OFF commands
public class RemoteControlMultiple {
    private Command[] onCommands;
    private Command[] offCommands;
    
    public RemoteControlMultiple(int devices) {
        onCommands = new Command[devices];
        
        offCommands = new Command[devices];
    }
    
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        
        offCommands[slot] = offCommand;
    }
    
    public void onButtonPressed(int slot) {
        onCommands[slot].execute();
    }
    
    public void offButtonPressed(int slot) {
        offCommands[slot].execute();
    }

    @Override
    public String toString() {
        return "RemoteControlMultiple{" + "onCommands=" + Arrays.toString(onCommands) + ", offCommands=" + Arrays.toString(offCommands) + '}';
    }
    
    public static void main(String[] args) {
        RemoteControlMultiple remoteControlMultiple = new RemoteControlMultiple(3);
        
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
        
        remoteControlMultiple.setCommand(0, commandLightKitchenOn, commandLightKitchenOff);
        remoteControlMultiple.setCommand(1, commandDoorGarageOpen, commandDoorGrarageClose);
        remoteControlMultiple.setCommand(2, commandLightLivingRoomOn, commandLightLivingRoomOff);
        
        remoteControlMultiple.onButtonPressed(2);
        remoteControlMultiple.offButtonPressed(1);
        remoteControlMultiple.offButtonPressed(0);
        
        System.out.println(remoteControlMultiple);
    }
}
