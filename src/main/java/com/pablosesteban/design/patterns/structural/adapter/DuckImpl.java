/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.adapter;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class DuckImpl implements Duck {
    @Override
    public void quack() {
        System.out.println("QUACKING");
    }

    @Override
    public void fly() {
        System.out.println("FLYING");
    }
    
}
