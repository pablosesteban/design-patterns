/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.command;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
COMMAND INTERFACE
    declares an interface for all Commands

    contains a method (typically called "execute") that encapsulates the actions and can be called to invoke the actions on the Receiver
*/
public interface Command {
    void execute();
    
}
