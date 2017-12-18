/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.behavioral.command;

import com.pablosesteban.design_patterns.patterns.behavioral.command.device.Light;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class CommandLightOn implements Command {
    private Light light;
    
    public void setLight(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

    @Override
    public String toString() {
        return "CommandLightOn{" + "light=" + light + '}';
    }
    
}
