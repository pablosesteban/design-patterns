/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.command;

import com.pablosesteban.design.patterns.behavioral.command.device.Door;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class CommandDoorOpen implements Command {
    private Door door;
    
    public void setDoor(Door door) {
        this.door = door;
    }
    
    @Override
    public void execute() {
        door.up();
    }

    @Override
    public String toString() {
        return "CommandDoorOpen{" + "door=" + door + '}';
    }
    
}
