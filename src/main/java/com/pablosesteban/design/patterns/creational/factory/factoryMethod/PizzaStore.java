/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.factoryMethod;

import com.pablosesteban.design.patterns.creational.factory.product.Pizza;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: FACTORY METHOD
what we’d really like to do is create a framework that ties the store and the pizza creation together, yet still allows things to remain flexible

we’ve gone from having an object handle the instantiation of our concrete classes to a set of subclasses that are now taking on that responsibility

this class has no idea what real concrete classes of Pizza are involved, i.e. it’s decoupled!

the subclasses of this class aren’t really “deciding” anything about what kind of Pizza is made, it was you who decided by choosing which store you wanted
*/
public abstract class PizzaStore {
    // all subclasses make use of this method defined here
    public final Pizza orderPizza(String type) {
        // instead of having the code of instantiating the concrete pizza (code that varies) here, let's subclasses to make the decision about what makes up a pizza
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
        handles object creation and encapsulates it in a subclass, this decouples the client code in the superclass from the object creation code in the subclass
    
        a factory method:
            is abstract so the subclasses are counted on to handle object creation
            
            returns a Product that is typically used within methods defined in the superclass
            
            may be parameterized (or not) to select among several variations of a product
            
            isolates the client (the code in the superclass, like orderPizza()) from knowing what kind of concrete Product is actually created
    
        each subclass is going to make the decision about what makes up a pizza
    
        letting each subclass of PizzaStore define what the createPizza() method looks like
    
        all the responsibility for instantiating Pizzas has been moved into a method that acts as a factory
    */
    protected abstract Pizza createPizza(String type);
    
    public static void main(String[] args) {
        
    }
}
