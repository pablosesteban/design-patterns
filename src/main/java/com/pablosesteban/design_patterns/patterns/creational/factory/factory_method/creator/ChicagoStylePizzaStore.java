/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.creational.factory.factory_method.creator;

import com.pablosesteban.design_patterns.patterns.creational.factory.factory_method.product.ChicagoStyleCheesePizza;
import com.pablosesteban.design_patterns.patterns.creational.factory.factory_method.product.ChicagoStylePepperoniPizza;
import com.pablosesteban.design_patterns.patterns.creational.factory.factory_method.product.Pizza;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CONCRETE CREATOR (regional store):
    is fully responsible for which concrete product it instantiates, so it has to implements the factory method for creating the product
*/
public class ChicagoStylePizzaStore extends AbstractPizzaStore {
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
