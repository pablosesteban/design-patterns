/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.creational.factory.abstract_factory.creator.pizza_store;

import com.pablosesteban.design_patterns.creational.factory.abstract_factory.creator.ingredient.ChicagoIngredientFactory;
import com.pablosesteban.design_patterns.creational.factory.abstract_factory.product.pizza.CheesePizza;
import com.pablosesteban.design_patterns.creational.factory.abstract_factory.product.pizza.PepperoniPizza;
import com.pablosesteban.design_patterns.creational.factory.abstract_factory.product.pizza.Pizza;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class ChicagoStylePizzaStore extends AbstractPizzaStore {
    public ChicagoStylePizzaStore() {
        ingredientFactory = new ChicagoIngredientFactory();
    }
    
    @Override
    protected Pizza createPizza(String type) {
        Pizza p = null;
        
        switch (type) {
            case "cheese":
                p = new CheesePizza(ingredientFactory);
                p.setName("Chicago Style Cheese Pizza");
                
                break;
            case "pepperoni":
                p = new PepperoniPizza(ingredientFactory);
                p.setName("Chicago Style Cheese Pizza");
                
                break;
            default:
                throw new IllegalArgumentException("No such kind of pizza: " + type);
        }
        
        return p;
    }
    
}
