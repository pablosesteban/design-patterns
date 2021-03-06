/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.observer;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
SUBJECT INTERFACE
    this interface gives Observers a way to register as observers and also to remove themselves from being observers

    also gives to Subject a way to update all the current observers whenever state changes

    is the only object that contains the state and controls it, it is the sole owner of the data leading to a cleaner OO design than allowing many object to control the same data
*/
public interface Subject {
    // observer to be registered
    void register(Observer o);
    
    // observer to be removed
    void remove(Observer o);
    
    // notify all observers when the Subject’s state has changed
    void notifyObservers();
    
}
