/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.structural.decorator.badapproach1_0;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class DarkRoastWithSteamedMilkAndMocha extends Beverage {
    public DarkRoastWithSteamedMilkAndMocha() {
        description = "Dark Roast Coffee with Steamed Milk and Mocha";
    }
    
    @Override
    public float cost() {
        return 2.99f;
    }
    
}
