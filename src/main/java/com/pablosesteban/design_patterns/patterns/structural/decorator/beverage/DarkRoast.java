/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.structural.decorator.beverage;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CONCRETE COMPONENT
    is the object we are going to dynamically add new behavior to

    the object which is going to be wrapped (decorated) by a decorator
*/
public class DarkRoast extends Beverage {
    private static final float COST = 0.99f;
    
    // set a description for this specific beverage
    public DarkRoast() {
        description = "Dark Roast";
    }
    
    // only need to return the price of this kind of beverage
    @Override
    public float cost() {
        return COST;
    }
    
}
