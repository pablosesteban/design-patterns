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
public interface Subject {
    // Observer to be registered
    void register(Observer o);
    
    // Observer to be removed
    void remove(Observer o);
    
    // notify all observers when the Subject’s state has changed
    void notifyObservers();
    
}
