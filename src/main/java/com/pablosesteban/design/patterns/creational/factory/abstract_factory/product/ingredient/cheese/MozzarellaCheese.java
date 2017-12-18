/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstract_factory.product.ingredient.cheese;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class MozzarellaCheese implements Cheese {
    private final String name = "Mozzarella Cheese";
    
    @Override
    public String getName() {
        return name;
    }
    
}