/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstract_factory.product.pizza;

import com.pablosesteban.design.patterns.creational.factory.abstract_factory.creator.ingredient.IngredientFactory;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class CheesePizza extends Pizza {
    public CheesePizza(IngredientFactory factory) {
        name = "Cheese Pizza";
        
        this.factory = factory;
    }
    
    /*
    the ingredients produced depend on which factory we’re using
    
    Pizza class doesn’t care which is being used, it knows how to make pizzas
    
    it’s decoupled from the differences in regional ingredients and can be easily reused
    
    each time it needs an ingredient, it asks the factory to produce it (if this is a NY factory, then we get NY ingredients)
    */
    @Override
    public void prepare() {
        System.out.println("Preparing " + name + "...");
        
        dough = factory.createDough();
        System.out.println("\tTossing " + dough.getName() + "...");
        
        sauce = factory.createSauce();
        System.out.println("\tAdding " + sauce.getName() + "...");
        
        cheese = factory.createCheese();
        System.out.println("\tAdding " + cheese.getName() + "...");
    }
    
}
