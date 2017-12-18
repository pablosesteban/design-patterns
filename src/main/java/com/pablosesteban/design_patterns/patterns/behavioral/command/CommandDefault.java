/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.behavioral.command;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
"DESIGN PATTERN: NULL OBJECT"
    a null object is useful when you don’t have a meaningful object to return, and yet you want to remove the responsibility for handling null from the client

    acts as a surrogate and does nothing

    it is not actually a design pattern but it is usually used in conjunction with many Design Patterns
*/
public class CommandDefault implements Command {
    @Override
    public void execute() {
        
    }

    @Override
    public void undo() {
        
    }

    @Override
    public String toString() {
        return "CommandDefault{" + '}';
    }
    
}
