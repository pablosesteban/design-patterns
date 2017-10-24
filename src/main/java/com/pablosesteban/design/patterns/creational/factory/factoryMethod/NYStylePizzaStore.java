/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.factoryMethod;

import com.pablosesteban.design.patterns.creational.factory.product.NYStyleCheesePizza;
import com.pablosesteban.design.patterns.creational.factory.product.NYStylePepperoniPizza;
import com.pablosesteban.design.patterns.creational.factory.product.Pizza;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
you get all the PizzaStore functionality for free

all the regional stores need to do is subclass PizzaStore and supply a createPizza() method that implements their style of Pizza

the subclass is fully responsible for which concrete Pizza it instantiates
*/
public class NYStylePizzaStore extends PizzaStore {
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
