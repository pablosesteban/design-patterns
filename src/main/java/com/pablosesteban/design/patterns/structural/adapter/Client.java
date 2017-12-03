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
public class Client {
    public static void main(String[] args) {
        Duck duck = new DuckImpl();
        
        System.out.println("Duck");
        duck.quack();
        duck.fly();
        
        Turkey turkey = new TurkeyImpl();
        
        System.out.println("Turkey");
        turkey.gobble();
        turkey.fly();
        
        // using the turkey as a duck
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);
        
        System.out.println("TurkeyAdapter");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
