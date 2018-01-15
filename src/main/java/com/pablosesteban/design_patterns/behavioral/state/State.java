/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.state;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
STATE INTERFACE
    interface for ALL states

    contains a method for every action that could happen

    each state in our design is going to encapsulate a state through a class which implements this interface
*/
public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
    
}
