/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.command.remote;

import com.pablosesteban.design.patterns.behavioral.command.Command;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

// a simple remote control with only one button, i.e. with only one slot to hold a device to control
public class RemoteControlSimple {
    // to hold our command, which will control one device
    private Command slot;
    
    // if the client of this code wanted to change the behavior of the remote button
    public void setCommand(Command command) {
        slot = command;
    }
    
    public void buttonPressed() {
        slot.execute();
    }
    
}
