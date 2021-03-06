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
public class Milk extends CondimentDecorator {
    private static final float COST = 0.50f;
    
    public Milk(Beverage beverage) {
        this.beverage = beverage;
        
        description = ", Milk";
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + description;
    }

    @Override
    public float cost() {
        return beverage.cost() + COST;
    }
    
}
