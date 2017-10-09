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
OBSERVER INTERFACE
    this gives the Subject a common interface to talk to when it comes time to update the Observers

    just has one method that gets called when the Subject’s state changes
*/
public interface Observer {
    // TODO: better way of passing the updated state to the observers?
    void update(float temperature, float humidity, float pressure);
    
}
