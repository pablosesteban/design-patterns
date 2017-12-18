/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.product.pizza;

import com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.creator.ingredient.IngredientFactory;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class PepperoniPizza extends Pizza {
    public  PepperoniPizza(IngredientFactory factory) {
        name = "Pepperoni Pizza";
        
        this.factory = factory;
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing " + name + "...");
        
        dough = factory.createDough();
        System.out.println("\tTossing " + dough.getName() + "...");
        
        sauce = factory.createSauce();
        System.out.println("\tAdding " + sauce.getName() + "...");
        
        pepperoni = factory.createPepperoni();
        System.out.println("\tAdding " + pepperoni.getName() + "...");
    }
    
}
