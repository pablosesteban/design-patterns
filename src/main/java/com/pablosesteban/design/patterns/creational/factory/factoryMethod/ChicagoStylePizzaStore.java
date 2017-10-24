/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.factoryMethod;

import com.pablosesteban.design.patterns.creational.factory.product.ChicagoStyleCheesePizza;
import com.pablosesteban.design.patterns.creational.factory.product.ChicagoStylePepperoniPizza;
import com.pablosesteban.design.patterns.creational.factory.product.Pizza;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza p = null;
        
        switch(type) {
            case "cheese":
                p = new ChicagoStyleCheesePizza();
                
                break;
            case "pepperoni":
                p = new ChicagoStylePepperoniPizza();
                
                break;
            default:
                throw new IllegalArgumentException("No such kind of pizza: " + type);
        }
        
        return p;
    }
    
}
