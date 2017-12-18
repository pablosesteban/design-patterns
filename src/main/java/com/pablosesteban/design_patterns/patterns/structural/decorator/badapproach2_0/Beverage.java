/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.structural.decorator.badapproach2_0;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public abstract class Beverage {
    // set in each subclass and holds a description of the beverage
    protected String description;
    
    /*
    to know what condiments a beverage has
    
    there is no class explosion, but the problem is that not all kind of complements are appropriate for all beverages (ice tea...)
    */
    protected boolean whippedMilk;
    protected boolean steamedMilk;
    protected boolean mocha;
    
    private float whippedMilkCost = 0.50f;
    private float steamedMilkCost = 0.50f;
    private float mochaCost = 0.50f;
    
    public String getDescription() {
        return description;
    }
    
    /*
    calculate the costs associated with the condiments for a particular beverage instance

    subclasses will still override cost(), but they will also invoke the super version so that they can calculate the total cost of the basic beverage plus the costs of the added condiments
    */
    public float cost() {
        float cost = 0f;
        
        if (whippedMilk) {
            cost += whippedMilkCost;
        }
        
        if (steamedMilk) {
            cost += steamedMilkCost;
        }
        
        if (mocha) {
            cost += mochaCost;
        }
        
        return cost;
    }

    public boolean isWhippedMilk() {
        return whippedMilk;
    }

    public void setWhippedMilk(boolean whippedMilk) {
        this.whippedMilk = whippedMilk;
    }

    public boolean isSteamedMilk() {
        return steamedMilk;
    }

    public void setSteamedMilk(boolean steamedMilk) {
        this.steamedMilk = steamedMilk;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }
    
}
