/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstract_factory.product.pizza;

import com.pablosesteban.design.patterns.creational.factory.abstract_factory.creator.ingredient.IngredientFactory;
import com.pablosesteban.design.patterns.creational.factory.abstract_factory.product.ingredient.cheese.Cheese;
import com.pablosesteban.design.patterns.creational.factory.abstract_factory.product.ingredient.dough.Dough;
import com.pablosesteban.design.patterns.creational.factory.abstract_factory.product.ingredient.pepperoni.Pepperoni;
import com.pablosesteban.design.patterns.creational.factory.abstract_factory.product.ingredient.sauce.Sauce;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CLIENT
    the client of the abstract factory is written against it and then composed at runtime with an actual (concrete) factory
*/
public abstract class Pizza {
    // COMPOSITION
    protected IngredientFactory factory;
    
    protected String name;
    
    // factory-produced ingredients
    protected Dough dough;
    protected Cheese cheese;
    protected Sauce sauce;
    protected Pepperoni pepperoni;
    
    // abstract again!
    public abstract void prepare();
    
    public void bake() {
        System.out.println("Baking...");
    }
    
    public void cut() {
        System.out.println("Cutting...");
    }
    
    public void box() {
        System.out.println("Boxing...");
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
