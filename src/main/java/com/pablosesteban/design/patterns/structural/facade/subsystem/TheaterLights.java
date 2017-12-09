/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.facade.subsystem;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class TheaterLights {
    public void dim(int i) {
        System.out.println("Lights dimming to " + i + "%");
    }
    
    public void on() {
        System.out.println("Lights ON");
    }
    
}
