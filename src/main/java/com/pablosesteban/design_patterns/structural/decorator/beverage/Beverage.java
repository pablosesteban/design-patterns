/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.decorator.beverage;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
COMPONENT INTERFACE
    each component can be used on its own or wrapped by a decorator (same interface)
*/
public abstract class Beverage {
    protected String description;
    
    public String getDescription() {
        return description;
    }

    public abstract float cost();
    
}
