/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.decorator.condiment;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CONCRETE DECORATOR
    
*/
public class Mocha extends CondimentDecorator {
    private static final float COST = 0.50f;
    
    public Mocha() {
        description = " with Mocha";
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + description;
    }

    @Override
    public float cost() {
        return COST + beverage.cost();
    }
    
}
