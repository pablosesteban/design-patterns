/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.creational.factory.abstract_factory.product.ingredient.cheese;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class ReggianoCheese implements Cheese {
    private final String name = "Reggiano Cheese";
    
    public String getName() {
        return name;
    }
    
}
