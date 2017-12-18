/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.facade.subsystem;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class DvdPlayer {
    public void off() {
        System.out.println("DVD Player OFF");
    }
    
    public void on() {
        System.out.println("DVD Player ON");
    }
    
    public void play() {
        System.out.println("DVD Player PLAY");
    }
    
    public void eject() {
        System.out.println("DVD Player EJECT");
    }
    
    public void stop() {
        System.out.println("DVD Player STOP");
    }
}
