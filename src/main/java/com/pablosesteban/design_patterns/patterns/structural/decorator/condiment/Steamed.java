/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.structural.decorator.condiment;

import com.pablosesteban.design_patterns.patterns.structural.decorator.beverage.Beverage;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class Steamed extends CondimentDecorator {
    private static final float COST = 0.50f;
    
    public Steamed(Beverage beverage) {
        this.beverage = beverage;
        
        description = ", Steamed";
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
