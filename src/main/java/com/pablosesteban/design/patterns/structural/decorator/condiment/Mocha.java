/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.decorator.condiment;

import com.pablosesteban.design.patterns.structural.decorator.beverage.Beverage;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CONCRETE DECORATOR
*/
public class Mocha extends CondimentDecorator {
    private static final float COST = 0.50f;
    
    /*
    we’re going to instantiate the concrete decorators with a reference to a beverage
        
    we’re going to pass the beverage we’re wrapping to the decorator’s constructor
    */
    public Mocha(Beverage beverage) {
        // set the instance variable to the beverage we are wrapping
        this.beverage = beverage;
        
        // set the description of the decorator
        description = ", Mocha";
    }
    
    @Override
    public String getDescription() {
        // first DELEGATE the call to the object we are decorating to get its description, then append its own description
        return beverage.getDescription() + description;
    }

    @Override
    public float cost() {
        // first, DELEGATE the call to the object we are decorating to get its cost, then add its own cost
        return beverage.cost() + COST;
    }
    
}
