/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstractFactory;

import com.pablosesteban.design.patterns.creational.factory.abstractFactory.creator.IngredientFactory;

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
        System.out.println("Tossing " + dough.getName() + "...");
        
        sauce = factory.createSauce();
        System.out.println("Adding " + sauce.getName() + "...");
        
        pepperoni = factory.createPepperoni();
        System.out.print("Adding " + pepperoni.getName() + "...");
    }
    
}
