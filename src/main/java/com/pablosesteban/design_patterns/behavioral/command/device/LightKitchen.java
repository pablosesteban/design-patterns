/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.command.device;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class LightKitchen implements Light {
    @Override
    public void on() {
        System.out.println("Kitchen Light ON");
    }

    @Override
    public void off() {
        System.out.println("Kitchen Light OFF");
    }

    @Override
    public String toString() {
        return "LightKitchen{" + '}';
    }
    
}
