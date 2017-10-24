/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.simple;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CLIENT
    just becomes a client of the factory object
    
    any time it needs a pizza it asks the pizza factory to make one
    
    doesn't care about the kind of pizzas, just cares that it gets a pizza, which implements the Pizza interface so that it can call prepare(), bake(), cut(), and box()
*/
public class PizzaStore {
    SimplePizzaFactory factory;
    
    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }
    
    public Pizza orderPizza(String type) {
        // instead of having the code of instantiating the concrete pizza (code that varies) here, call the factory to do that
        Pizza p = factory.createPizza(type);
        
        // don’t expect this code to change
        p.prepare();
        p.bake();
        p.cut();
        p.box();
        
        return p;
    }
    
    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        
        pizzaStore.orderPizza("cheese");
        pizzaStore.orderPizza("pepperoni");
        pizzaStore.orderPizza("barbecue");
    }
}
