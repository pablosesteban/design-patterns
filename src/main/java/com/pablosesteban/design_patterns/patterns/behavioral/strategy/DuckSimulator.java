/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.behavioral.strategy;

import com.pablosesteban.design_patterns.patterns.behavioral.strategy.behavior.fly.FlyNoWay;
import com.pablosesteban.design_patterns.patterns.behavioral.strategy.duck.DecoyDuck;
import com.pablosesteban.design_patterns.patterns.behavioral.strategy.duck.MallardDuck;
import com.pablosesteban.design_patterns.patterns.behavioral.strategy.duck.RubberDuck;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: STRATEGY
    defines a family of algorithms, encapsulates each one, and makes them interchangeable

    lets the algorithm vary independently from clients that use it
*/
public class DuckSimulator {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        DecoyDuck decoyDuck = new DecoyDuck();
        RubberDuck rubberDuck = new RubberDuck();
        
        System.out.println("Mallar Duck:");
        mallardDuck.performFly();
        mallardDuck.performQuack();
        
        System.out.println("Decoy Duck:");
        decoyDuck.performFly();
        decoyDuck.performQuack();
        
        System.out.println("Rubber Duck:");
        rubberDuck.performFly();
        rubberDuck.performQuack();
        
        System.out.println("Mallar Duck:");
        mallardDuck.setFlyBehavior(new FlyNoWay());
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }
}
