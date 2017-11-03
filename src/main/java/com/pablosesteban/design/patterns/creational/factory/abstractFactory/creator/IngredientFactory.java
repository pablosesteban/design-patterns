/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstractFactory.creator;

import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.cheese.Cheese;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.dough.Dough;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.pepperoni.Pepperoni;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.sauce.Sauce;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

// if we’d had some common “machinery” to implement in each instance of factory, we could have made this an abstract class instead...
public interface IngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Pepperoni createPepperoni();
    
}
