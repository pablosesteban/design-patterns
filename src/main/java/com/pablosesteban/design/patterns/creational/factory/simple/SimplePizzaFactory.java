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
public class SimplePizzaFactory {
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
                
        }
        
        return p;
    }
}
