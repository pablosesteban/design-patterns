/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.decorator;

import com.pablosesteban.design.patterns.structural.decorator.beverage.Beverage;
import com.pablosesteban.design.patterns.structural.decorator.beverage.DarkRoast;
import com.pablosesteban.design.patterns.structural.decorator.condiment.Milk;
import com.pablosesteban.design.patterns.structural.decorator.condiment.Mocha;
import com.pablosesteban.design.patterns.structural.decorator.condiment.Steamed;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage darkRoast = new DarkRoast();
        System.out.println(darkRoast.getDescription() + ": " + darkRoast.cost());
        
        Beverage darkRoastWithMocha = new DarkRoast();
        darkRoastWithMocha = new Mocha(darkRoastWithMocha);
        System.out.println(darkRoastWithMocha.getDescription() + ": " + darkRoastWithMocha.cost());
        
        // make a DarkRoast object
        Beverage darkRoastWithMochaAndSteamedMilk = new DarkRoast();
        // wrap it in a Mocha object
        darkRoastWithMochaAndSteamedMilk = new Mocha(darkRoastWithMochaAndSteamedMilk);
        // wrap it in a Steamed object
        darkRoastWithMochaAndSteamedMilk = new Steamed(darkRoastWithMochaAndSteamedMilk);
        // wrap it in a Milk object
        darkRoastWithMochaAndSteamedMilk = new Milk(darkRoastWithMochaAndSteamedMilk);
        System.out.println(darkRoastWithMochaAndSteamedMilk.getDescription() + ": " + darkRoastWithMochaAndSteamedMilk.cost());
    }
}
