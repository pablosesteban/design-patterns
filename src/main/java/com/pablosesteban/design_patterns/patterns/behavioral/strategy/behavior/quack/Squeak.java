/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.behavioral.strategy.behavior.quack;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("SQUEAK!");
    }
    
}
