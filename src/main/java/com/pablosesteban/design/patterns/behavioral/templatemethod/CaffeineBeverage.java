/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.templatemethod;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public abstract class CaffeineBeverage {
    //TEMPLATE METHOD: controls the algorithm but at certain points in the algorithm, it lets the subclass supply the implementation of the steps
    public final void prepareBeverage() {
        //ALGORITHM
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    
    protected void boilWater() {
        System.out.println("Boiling water");
    }
    
    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }
    
    protected abstract void brew();
    protected abstract void addCondiments();
    
    public static void main(String[] args) {
        System.out.println("-------Preparing Tea-------");
        Tea tea = new Tea();
        tea.prepareBeverage();
        
        System.out.println("-------Preparing Coffee-------");
        Coffee coffee = new Coffee();
        coffee.prepareBeverage();
    }
}
