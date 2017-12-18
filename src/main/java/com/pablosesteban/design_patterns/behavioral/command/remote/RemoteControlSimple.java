/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.command.remote;

import com.pablosesteban.design_patterns.behavioral.command.Command;
import com.pablosesteban.design_patterns.behavioral.command.CommandDoorOpen;
import com.pablosesteban.design_patterns.behavioral.command.CommandLightOff;
import com.pablosesteban.design_patterns.behavioral.command.device.Door;
import com.pablosesteban.design_patterns.behavioral.command.device.DoorGarage;
import com.pablosesteban.design_patterns.behavioral.command.device.Light;
import com.pablosesteban.design_patterns.behavioral.command.device.LightLivingRoom;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
INVOKER
    holds a command and at some point asks the command to carry out a request by calling its execute() method

    in this case it is a simple remote control with only one button, i.e. with only one slot to hold a device to control
*/
public class RemoteControlSimple {
    /*
    to hold our Command, which will control one device
    
    didn’t care what Command object it had, as long as it implemented the Command interface
    */
    private Command slot;
    
    // if the client of this code wanted to change the behavior of the remote button
    public void setCommand(Command command) {
        slot = command;
    }
    
    /*
    doesn't really know what actions get performed on what Receiver
    
    they just know that if they call the execute() method, their request will be serviced
    */
    public void buttonPressed() {
        slot.execute();
    }
    
    /*
    CLIENT
        this method acts as a client
    
        is responsible for creating a Concrete Command and setting its Receiver
    */
    public static void main(String[] args) {
        // the INVOKER: it will be passed a Command object and will ask it to carry out a request
        RemoteControlSimple remote = new RemoteControlSimple();
        
        // the RECEIVER of the request
        Light livingRoomLight = new LightLivingRoom();
        Door garageDoor = new DoorGarage();
        
        // the COMMAND: pass the Receiver to it
        CommandLightOff lightOff = new CommandLightOff(livingRoomLight);
        CommandDoorOpen doorOpen = new CommandDoorOpen();
        doorOpen.setDoor(garageDoor);
        
        // PARAMETRIZING THE INVOKER WITH COMMANDS: pass the Commands to the Invoker
        remote.setCommand(lightOff);
        // simulates a button being pressed
        remote.buttonPressed();
        
        remote.setCommand(doorOpen);
        remote.buttonPressed();
    }
    
}
