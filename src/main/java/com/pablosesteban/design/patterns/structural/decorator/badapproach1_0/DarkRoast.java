/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.decorator.badapproach1_0;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }
    
    @Override
    public float cost() {
        return 0.99f;
    }
    
}
