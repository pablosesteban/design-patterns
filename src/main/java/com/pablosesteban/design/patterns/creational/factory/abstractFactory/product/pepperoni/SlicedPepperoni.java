/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.pepperoni;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class SlicedPepperoni implements Pepperoni {
    private final String name = "Sliced Pepperoni";
    
    public String getName() {
        return name;
    }
    
}
