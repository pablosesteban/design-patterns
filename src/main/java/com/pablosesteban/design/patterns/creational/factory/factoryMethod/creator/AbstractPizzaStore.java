/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.factoryMethod.creator;

import com.pablosesteban.design.patterns.creational.factory.factoryMethod.product.Pizza;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CLIENT
    this class just becomes a client of the factory method
    
    any time it needs a product it asks the factory method to make one
    
    doesn't care about the kind of the concrete product, just cares that it gets a concrete product, which implements the abstract product interface
*/

/*
ABSTRACT CREATOR (franchise)
    defines an abstract factory method that the subclasses implement to produce products
    
    createPizza method is back to being a call to a method in the PizzaStore rather than on a simple factory object
*/
public abstract class AbstractPizzaStore {
    /*
    all subclasses make use of this method defined here (final) to ensure that it’s consistent across all subclasses (more control)
    
    this method has no idea what real concrete classes of the product are involved, i.e. it’s decoupled
    
    this method gets an instance of the product using the factory method but it is not deciding which subclass is in the game
    */
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
    */
    protected abstract Pizza createPizza(String type);
    
    public static void main(String[] args) {
        AbstractPizzaStore nyStore = new NYStylePizzaStore();
        AbstractPizzaStore chicagoStore = new ChicagoStylePizzaStore();
        
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
        
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
    
}
