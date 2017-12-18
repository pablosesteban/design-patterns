/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.behavioral.command;

import java.util.Arrays;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
MACRO COMMAND
    a Command that can execute other Commands (more than one)
*/
public class CommandMacro implements Command {
    private Command[] commands;
    
    public CommandMacro(Command[] commands) {
        this.commands = commands;
    }
    
    @Override
    public void execute() {
        // all the Commands in the macro are executed when we invoke it
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }

    @Override
    public String toString() {
        return "CommandMacro{" + "commands=" + Arrays.toString(commands) + '}';
    }
    
}
