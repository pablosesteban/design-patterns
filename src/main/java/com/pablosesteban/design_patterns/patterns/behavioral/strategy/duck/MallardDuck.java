/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.behavioral.strategy.duck;

import com.pablosesteban.design_patterns.patterns.behavioral.strategy.behavior.fly.FlyWithWings;
import com.pablosesteban.design_patterns.patterns.behavioral.strategy.behavior.quack.Quack;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class MallardDuck extends Duck {
    // they are supossed to quack and fly!
    public MallardDuck() {
        /*
        uses the FlyWithWings class to handle its fly behavior
        
        uses the Quack class to handle its quack behavior
        
        NOTE WELL: we are doing a poor job of initializing the instance variables in a flexible way...
        */
        flyBehavior = new FlyWithWings();
        
        quackBehavior = new Quack();
    }
    
    @Override
    public void display() {
        System.out.println("MALLARD DUCK!");
    }
    
}
