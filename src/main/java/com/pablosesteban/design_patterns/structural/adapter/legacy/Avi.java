/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.adapter.legacy;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class Avi implements OldFormat {
    @Override
    public void playFile() {
        System.out.println("Playing avi file");
    }

    @Override
    public String toString() {
        return "Avi{" + '}';
    }
    
}
