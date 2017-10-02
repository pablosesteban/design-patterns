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
public interface Observer {
    // TODO: encapsulate the state to change...
    void update(float temperature, float humidity, float pressure);
    
}
