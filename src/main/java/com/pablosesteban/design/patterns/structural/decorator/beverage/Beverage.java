/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.decorator.beverage;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
COMPONENT INTERFACE
*/
public abstract class Beverage {
    public enum Size {
        SMALL, MEDIUM, LARGE;
    }
    
    protected Size size;
    protected String description;
    
    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    
    public abstract float cost();
    
}
