/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.strategy.duck;

import com.pablosesteban.design_patterns.behavioral.strategy.behavior.fly.FlyNoWay;
import com.pablosesteban.design_patterns.behavioral.strategy.behavior.quack.Squeak;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class RubberDuck extends Duck {
    // they don't quack but squeak
//    @Override
//    public void quack() {
//        System.out.println("SQUEAKING!");
//    }
    
    // they are not supposed to fly!
//    @Override
//    public void fly() {
//        // DO NOTHING!
//    }
    
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        
        quackBehavior = new Squeak();
    }
    
    @Override
    public void display() {
        System.out.println("RUBBER DUCK!");
    }
    
}
