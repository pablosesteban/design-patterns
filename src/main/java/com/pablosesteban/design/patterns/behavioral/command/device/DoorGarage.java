/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.command.device;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class DoorGarage implements Door {
    @Override
    public void up() {
        System.out.println("Garage Door UP");
    }

    @Override
    public void down() {
        System.out.println("Garage Door DOWN");
    }

    @Override
    public String toString() {
        return "DoorGarage{" + '}';
    }
    
}
