/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.creator.ingredient;

import com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.product.ingredient.cheese.Cheese;
import com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.product.ingredient.cheese.MozzarellaCheese;
import com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.product.ingredient.dough.Dough;
import com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.product.ingredient.dough.ThinCrustDough;
import com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.product.ingredient.pepperoni.Pepperoni;
import com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.product.ingredient.pepperoni.SlicedPepperoni;
import com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.product.ingredient.sauce.Sauce;
import com.pablosesteban.design_patterns.patterns.creational.factory.abstract_factory.product.ingredient.sauce.TomatoSauce;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
CONCRETE FACTORY
    implement the different product families

    each concrete factory can produce an entire set of products

    to create a product, the client uses one of these factories, so it never has to instantiate a product object
*/
public class ChicagoIngredientFactory implements IngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new TomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }
    
}
