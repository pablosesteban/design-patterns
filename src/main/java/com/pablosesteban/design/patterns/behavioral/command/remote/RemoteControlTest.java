/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.command.remote;

import com.pablosesteban.design.patterns.behavioral.command.CommandLightOn;
import com.pablosesteban.design.patterns.behavioral.command.device.Light;
import com.pablosesteban.design.patterns.behavioral.command.device.LightLivingRoom;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

// the CLIENT
public class RemoteControlTest {
    public static void main(String[] args) {
        // the INVOKER: it will be passed a command object that can be used to make requests
        RemoteControlSimple remote = new RemoteControlSimple();
        
        // the RECEIVER of the request
        Light light = new LightLivingRoom();
        
        // the COMMAND: pass the Receiver to it
        CommandLightOn lightOn = new CommandLightOn(light);
        
        // pass the command to the Invoker
        remote.setCommand(lightOn);
        
        // simulates a button being pressed
        remote.buttonPressed();
    }
}
