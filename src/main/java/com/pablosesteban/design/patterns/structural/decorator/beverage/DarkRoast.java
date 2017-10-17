/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.decorator.beverage;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CONCRETE COMPONENT
    
*/
public class DarkRoast extends Beverage {
    private static final float COST = 0.99f;
    
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }
    
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float cost() {
        return COST;
    }
    
}
