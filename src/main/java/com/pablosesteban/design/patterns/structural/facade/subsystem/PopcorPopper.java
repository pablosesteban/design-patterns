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
public class PopcorPopper {
    public void on() {
        System.out.println("Popcorn Popper ON");
    }
    
    public void off() {
        System.out.println("Popcorn Popper OFF");
    }
    
    public void pop() {
        System.out.println("Popcorn Popper POPPING");
    }
    
}
