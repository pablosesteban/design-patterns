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
    all Command objects implement the same interface

    consists of a set of actions on a Receiver

    contains one method (typically use the name execute) that encapsulates the actions and can be called to invoke the actions on the Receiver

    the actions and the Receiver are bound together in this object
*/
public interface Command {
    void execute();
    
}
