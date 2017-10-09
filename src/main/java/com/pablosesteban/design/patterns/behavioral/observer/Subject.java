/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.observer;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
SUBJECT INTERFACE
    this interface gives Observers a way to register as observers and also to remove themselves from being observers

    also gives to Subject a way to update all the current observers whenever state changes
*/
public interface Subject {
    // observer to be registered
    void register(Observer o);
    
    // observer to be removed
    void remove(Observer o);
    
    // notify all observers when the Subject’s state has changed
    void notifyObservers();
    
}
