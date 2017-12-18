/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.creational.factory.simple_factory.creator;

import com.pablosesteban.design_patterns.patterns.creational.factory.simple_factory.product.CheesePizza;
import com.pablosesteban.design_patterns.patterns.creational.factory.simple_factory.product.PepperoniPizza;
import com.pablosesteban.design_patterns.patterns.creational.factory.simple_factory.product.Pizza;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
"DESIGN PATTERN: SIMPLE FACTORY"
    all factory patterns encapsulate object creation but in different ways
    
    factories handle the details of object creation

    this "pattern" encapsulates object creation by letting the simple factory class decide what objects to create

    it isn’t actually a design pattern, it’s more of a programming idiom
*/

/*
CREATOR
    handles the instantiation of the concrete products
*/
public class SimplePizzaFactory {
    /*
    code which is going to vary
    
    if you don't encapsulates this kind of code, it ends up in several parts of the application making maintenance and updates more difficult and error-prone
    
    two desing principles are followed doing this:
        encapsulates what varies
    
        opened for extension, but closed for modification
    
    we now have only one place to make modifications when the implementation changes
   
    this is the method all clients will use to instantiate new concrete products
    
    this method can be STATIC and is a common technique (static factory)
        you don’t need to instantiate an object to make use of it
        
        has the disadvanage that you can’t subclass and change the behavior of the method
    */
    public Pizza createPizza(String type) {
        Pizza p = null;
        
        switch (type) {
            case "pepperoni":
                p = new PepperoniPizza();
                
                break;
            case "cheese":
                p = new CheesePizza();
                
                break;
            default:
                throw new IllegalArgumentException("No such kind of pizza: " + type);
        }
        
        return p;
    }
    
}
