/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.strategy.duck;

import com.pablosesteban.design.patterns.behavioral.strategy.behavior.fly.FlyNoWay;
import com.pablosesteban.design.patterns.behavioral.strategy.behavior.quack.MuteQuack;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class DecoyDuck extends Duck {
    // they are not supposed to fly!
//    @Override
//    public void fly() {
//        // DO NOTHING!
//    }
    // they are not supposed to quack!
//    @Override
//    public void quack() {
//        // DO NOTHING!
//    }
    
    public DecoyDuck() {
        flyBehavior = new FlyNoWay();
        
        quackBehavior = new MuteQuack();
    }
    
    @Override
    public void display() {
        System.out.println("DECOY DUCK!");
    }
    
}
