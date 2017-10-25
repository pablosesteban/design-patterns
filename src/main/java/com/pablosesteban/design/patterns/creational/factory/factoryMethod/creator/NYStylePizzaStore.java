/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.factoryMethod.creator;

import com.pablosesteban.design.patterns.creational.factory.factoryMethod.product.NYStyleCheesePizza;
import com.pablosesteban.design.patterns.creational.factory.factoryMethod.product.NYStylePepperoniPizza;
import com.pablosesteban.design.patterns.creational.factory.factoryMethod.product.Pizza;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: FACTORY METHOD
    all factory patterns encapsulate object creation but in different ways

    this pattern encapsulates object creation by letting subclasses decide what objects to create
    
    gone from having an object handle the instantiation of our concrete classes (simple factory) to a set of subclasses that are now taking on that responsibility
    
    all the responsibility for instantiating the product has been moved into a method that acts as a factory
*/

/*
subclass (regional store):
    isn't really “deciding” anything about what kind of pizza style is made, it was you who decided by choosing which store you wanted
    
    is fully responsible for which concrete product it instantiates, so it has to implements the factory method for creating the product
*/
public class NYStylePizzaStore extends AbstractPizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza p = null;
        
        switch(type) {
            case "cheese":
                p = new NYStyleCheesePizza();
                
                break;
            case "pepperoni":
                p = new NYStylePepperoniPizza();
                
                break;
            default:
                throw new IllegalArgumentException("No such kind of pizza: " + type);
        }
        
        return p;
    }
    
}
