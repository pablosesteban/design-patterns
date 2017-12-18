/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.decorator.badapproach1_0;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
abstract class subclassed by all beverages

the problem is that you can also ask for several condiments so there will be a CLASS EXPLOSION!
*/
public abstract class Beverage {
    // set in each subclass and holds a description of the beverage
    protected String description;
    
    public String getDescription() {
        return description;
    }
    
    // each subclass implements cost() to return the cost of the beverage
    public abstract float cost();
    
}
