/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstractFactory.creator.pizzaStore;

import com.pablosesteban.design.patterns.creational.factory.abstractFactory.creator.ingredient.IngredientFactory;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.pizza.Pizza;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public abstract class AbstractPizzaStore {
    // COMPOSITION
    protected IngredientFactory ingredientFactory;
    
    public final Pizza orderPizza(String type) {
        Pizza p = createPizza(type);
        
        // don’t expect this code to change
        p.prepare();
        p.bake();
        p.cut();
        p.box();
        
        return p;
    }
    
    /*
    FACTORY METHOD
        handles object creation and encapsulates it in a subclass
    
        decouples the client code in the superclass from the object creation code in the subclass
    
        a factory method:
            is abstract so the subclasses are counted on to handle object creation
            
            returns a product that is typically used within methods defined in the superclass
            
            isolates the client (the code in the superclass, like orderPizza()) from knowing what kind of concrete product is actually created
            
            may be parameterized (or not) to select among several variations of a product
    
        any other methods implemented are written to operate on products produced by the factory method
    */
    protected abstract Pizza createPizza(String type);
    
    public static void main(String[] args) {
        AbstractPizzaStore nyStore = new NYStylePizzaStore();
//        AbstractPizzaStore chicagoStore = new ChicagoStylePizzaStore();
        
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
        
//        pizza = chicagoStore.orderPizza("cheese");
//        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
    
}
