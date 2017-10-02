/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.strategy.behavior.fly;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("CAN'T FLY!");
    }
    
}
