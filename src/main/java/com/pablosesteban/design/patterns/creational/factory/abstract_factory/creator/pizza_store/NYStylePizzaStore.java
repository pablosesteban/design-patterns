/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstract_factory.creator.pizza_store;

import com.pablosesteban.design.patterns.creational.factory.abstract_factory.creator.ingredient.NYIngredientFactory;
import com.pablosesteban.design.patterns.creational.factory.abstract_factory.product.pizza.CheesePizza;
import com.pablosesteban.design.patterns.creational.factory.abstract_factory.product.pizza.PepperoniPizza;
import com.pablosesteban.design.patterns.creational.factory.abstract_factory.product.pizza.Pizza;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: FACTORY METHOD
    all factory patterns encapsulate object creation but in different ways
    
    defines an interface for creating an object, but lets subclasses decide which class to instantiate through a Factory Method that lets a class defer instantiation to subclasses

    this pattern encapsulates object creation by letting subclasses decide what objects to create
    
    gone from having an object handle the instantiation of our concrete classes (simple factory) to a set of subclasses that are now taking on that responsibility
    
    all the responsibility for instantiating the product has been moved into a method that acts as a factory
    
    creates a framework that ties the store and the pizza creation together, yet still allows things to remain flexible

    as a framework this pattern generates parallel class hierarchies (procucts and creators):
        both have abstract classes that are extended by concrete classes

        it encapsulates product knowledge into each creator, i.e. each subclass of the abstract creator encapsulates all the knowledge
        about how to create a subset of subclasses of the abstract product
        
        the factory method is the key to encapsulating this knowledge

    it is said that subclasses of abstract creator “decides” which class to instantiate:
        not because the pattern allows subclasses themselves to decide at runtime, but because the creator class is written without
        knowledge of the actual products that will be created, which is decided purely by the choice of the subclass that is used
   
    you can define the abstract creator as not abstract and a default factory method (not abstract) to produce some concrete product,
    then you always have a means of creating products even if there are no subclasses of the abstract creator

    is not the only technique for adhering to the "Dependency Inversion Principle", but it is one of the more powerful ones

DESIGN PRINCIPLE: depend upon abstractions, not upon concrete classes (Dependency Inversion)
    makes an even stronger statement about abstraction than "program to an interface, not to an implementation" principle

    suggests that our high-level components should not depend on our low-level components; rather, they should both depend on abstractions

    a "high-level" component is a class with behavior defined in terms of other, "low level" components
*/

/*
CONCRETE CREATOR (regional store):
    is fully responsible for which concrete product it instantiates, so it has to implements the factory method for creating the product
*/
public class NYStylePizzaStore extends AbstractPizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        // to produce the ingredients for all NY style pizzas
        ingredientFactory = new NYIngredientFactory();
        
        Pizza p = null;
        
        // for each type of Pizza, we instantiate a new Pizza and give it the factory it needs to get its ingredients
        switch(type) {
            case "cheese":
                p = new CheesePizza(ingredientFactory);
                
                p.setName("New York Style Cheese Pizza");
                
                break;
            case "pepperoni":
                p = new PepperoniPizza(ingredientFactory);
                
                p.setName("New York Style Pepperoni Pizza");
                
                break;
            default:
                throw new IllegalArgumentException("No such kind of pizza: " + type);
        }
        
        return p;
    }
    
}
