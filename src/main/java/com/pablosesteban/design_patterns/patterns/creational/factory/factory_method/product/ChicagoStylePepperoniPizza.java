/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.creational.factory.factory_method.product;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CONCRETE PRODUCT
    needs to implement the product interface so it can be created by the factory method and handed back to the client

    "low-level" component and it extends Pizza abstraction to achieve DI
*/
public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        name = "Chicago Style Pepperoni Pizza";
        dough = "Thick Crust Dough";
        sauce = "Tomato Sauce";
        toppings.add("Sliced Pepperoni");
    }
    
}
