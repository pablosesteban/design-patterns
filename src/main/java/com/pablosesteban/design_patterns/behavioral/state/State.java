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
    defines a common interface for ALL concrete states (making all of them interchangeable)

    contains a method for every action that could happen (state transition)

    each state in our design is going to encapsulate a state through a class which implements this interface

    lets localize the behavior of each state in its own class and close each state for modification but left the GumballMachine opened
    to extension by adding new state classes

    this could be an abstract class and build in some default behavior for the methods so all “error response” behavior could be
    generic and inherited from the abstract State class (avoid duplicated code)
*/
public interface State {
    // state transitions
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
