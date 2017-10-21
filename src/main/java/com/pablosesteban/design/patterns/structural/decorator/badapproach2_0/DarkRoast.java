/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.decorator.badapproach2_0;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }
    
    // compute the cost of the beverage and add in the condiments by calling super cost() method
    @Override
    public float cost() {
        return 1.99f + super.cost();
    }
    
}
