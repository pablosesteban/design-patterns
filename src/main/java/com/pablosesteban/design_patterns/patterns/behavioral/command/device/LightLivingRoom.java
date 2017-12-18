/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.behavioral.command.device;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
RECEIVER
    knows how to perform the work needed to carry out the request

    any class can act as a Receiver
*/
public class LightLivingRoom implements Light {
    @Override
    public void on() {
        System.out.println("Living Room Light ON");
    }

    @Override
    public void off() {
        System.out.println("Living Room Light OFF");
    }

    @Override
    public String toString() {
        return "LightLivingRoom{" + '}';
    }
    
}
