/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.command;

import com.pablosesteban.design.patterns.behavioral.command.device.Light;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CONCRETE COMMAND
    defines a binding between an action and a Receiver

    it packages the actions and the Receiver up into an object that exposes just one method

    the actions and the Receiver are bound together in this object

    the Invoker makes a request by calling execute() and the Concrete Command carries it out by calling one or more actions on the Receiver
*/
public class CommandLightOff implements Command {
    // the Receiver object (of the request)
    private Light ligth;

    // sets the specific light that this command is going to control
    public CommandLightOff(Light ligth) {
        this.ligth = ligth;
    }
    
    // a Command is invoked through its execute() method, which asks a receiver to perform an action
    @Override
    public void execute() {
        // causes the action(s) to be invoked on the receiver
        ligth.off();
    }

    @Override
    public String toString() {
        return "CommandLightOff{" + "ligth=" + ligth + '}';
    }
    
}
