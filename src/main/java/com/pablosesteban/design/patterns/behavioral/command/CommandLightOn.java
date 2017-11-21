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
public class CommandLightOn implements Command {
    // the Receiver object (of the request)
    private Light ligth;

    // the specific light that this command is going to control (say the living room light)
    public CommandLightOn(Light ligth) {
        this.ligth = ligth;
    }
    
    @Override
    public void execute() {
        ligth.on();
    }
    
}
