/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.decorator.condiment;

import com.pablosesteban.design_patterns.structural.decorator.beverage.Beverage;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CONCRETE DECORATOR
    can extend the state (instance variables) of the component

    can add new functionality (methods) to the component
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
    
    /*
    DELEGATION
        first DELEGATE the call to the object we are decorating to get its description, then append its own description
    
        first DELEGATE the call to the object we are decorating to get its cost, then add its own cost
    */
    @Override
    public String getDescription() {
        return beverage.getDescription() + description;
    }

    @Override
    public float cost() {
        return beverage.cost() + COST;
    }
    
}
