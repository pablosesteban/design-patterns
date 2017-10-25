/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.factoryMethod.product;

import java.util.ArrayList;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
ABSTRACT PRODUCT
    this is the product of the factory

    abstract product for all products
*/
public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected ArrayList<String> toppings = new ArrayList<>();
    
    public void prepare() {
        System.out.println("Preparing " + name + "...");
        System.out.println("Tossing " + dough + "...");
        System.out.println("Adding " + sauce + "...");
        System.out.print("Adding toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i));
        }
    }
    
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
