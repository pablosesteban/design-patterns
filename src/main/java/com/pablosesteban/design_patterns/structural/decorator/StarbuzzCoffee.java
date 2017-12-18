/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.decorator;

import com.pablosesteban.design_patterns.structural.decorator.beverage.Beverage;
import com.pablosesteban.design_patterns.structural.decorator.beverage.DarkRoast;
import com.pablosesteban.design_patterns.structural.decorator.condiment.Milk;
import com.pablosesteban.design_patterns.structural.decorator.condiment.Mocha;
import com.pablosesteban.design_patterns.structural.decorator.condiment.Steamed;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: DECORATOR
    ataches additional resposibilities to an object dynamically

    decorators provide a flexible alternative to subclassing for extending functionality

    uses inheritance to achieve the type matching of the decorators (same as component) not to inherit its behavior

    uses composition to add new functionality at runtime

    if we rely on inheritance to get the behavior
        it can only be determined statically at compile time
        
        we get only behavior the superclass gives us or that we override
        
        to add new behavior we have to change the existing code

DESIGN PRINCIPLE: classes should be opened for extension, but closed for modification
    classes must allow extends our classes with any new behavior, but without altering the existing code

    the goal is to allow classes to be easily extended to incorporate new behavior without modifying existing code

    following this principle usually introduces new levels of abstraction, which adds complexity to the code, so concentrate
    on those areas that are most likely to change in your designs and apply the principles there
*/
public class StarbuzzCoffee {
    public static void main(String[] args) {
        /*
        a better way of creating decorated objects is using the Factory and Builder patterns where the creation of
        the concrete component with its decorator is well encapsulated
        */
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
