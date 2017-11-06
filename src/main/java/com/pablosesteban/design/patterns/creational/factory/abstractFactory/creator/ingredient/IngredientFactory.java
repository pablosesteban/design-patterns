/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstractFactory.creator.ingredient;

import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.ingredient.cheese.Cheese;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.ingredient.dough.Dough;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.ingredient.pepperoni.Pepperoni;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.ingredient.sauce.Sauce;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: ABSTRACT FACTORY
    provides an interface for creating families of related or dependent objects without specifying their concrete classes
    
    allows a client to use an abstract interface to create a set of related products without knowing (or caring) about the concrete products that are actually produced

    the client is decoupled from any of the specifics of the concrete products

    gives us an interface for creating a family of products and decouple our code from the actual factory that creates the products

    allows us to implement a variety of factories that produce products meant for different contexts such us different look and feels
*/

/*
ABSTRACT FACTORY
   defines the interface that all concrete factories must implement, which consists of a set of methods for producing products

    if we’d had some common “machinery” to implement in each instance of factory, we could have made this an abstract class instead...
*/
public interface IngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Pepperoni createPepperoni();
    
}
