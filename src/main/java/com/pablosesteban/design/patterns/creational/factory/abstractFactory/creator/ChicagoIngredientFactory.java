/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstractFactory.creator;

import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.cheese.Cheese;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.cheese.MozzarellaCheese;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.dough.Dough;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.dough.ThinCrustDough;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.pepperoni.Pepperoni;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.pepperoni.SlicedPepperoni;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.sauce.Sauce;
import com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.sauce.TomatoSauce;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
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
