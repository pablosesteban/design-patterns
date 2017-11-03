/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstractFactory;

import com.pablosesteban.design.patterns.creational.factory.abstractFactory.creator.IngredientFactory;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.cheese.Cheese;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.dough.Dough;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.pepperoni.Pepperoni;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.sauce.Sauce;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
ABSTRACT PRODUCT
    this is the product of the factory method

    abstract product for all products

    this is the key interface to apply the DI principle:
        high-level components use this abstraction to define its behavior

        low-level components extends this abstraction to define itselfs
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
    
}
