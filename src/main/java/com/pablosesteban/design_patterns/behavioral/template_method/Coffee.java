/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.template_method;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CONCRETE CLASS
    implements one or more specific steps of the algorithm

    is the low-level component in the Hollywood Design Principle
        never call the abstract class directly without being “called” first
*/
public class Coffee extends CaffeineBeverage {
    private boolean hasCondiments;
    
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    // overriding the hook method
    @Override
    protected boolean hasCondiments() {
        return hasCondiments;
    }
    
    public void setHasCondiments(boolean hasCondiments) {
        this.hasCondiments = hasCondiments;
    }
    
}
