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
SIMPLE FACTORY
    the Simple Factory isn’t actually a Design Pattern, it’s more of a programming idiom
    
    factories handle the details of object creation

    is only going to be concerned with creating pizzas
*/
public class SimplePizzaFactory {
    /*
    code which is going to vary (add/delete kinds of pizza)
    
    several concrete classes to be instantiated and the decision of which to instantiate is made at runtime depending on some set of conditions
    
    if you don't encapsulates this kind of code, it ends up in several parts of the application making maintenance and updates more difficult and error-prone
    
    two desing principles are followed doing this:
        encapsulates what varies
    
        opened for extension, but closed for modification
    
    we now have only one place to make modifications when the implementation changes
   
    the method all clients will use to instantiate new pizzas
    
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
