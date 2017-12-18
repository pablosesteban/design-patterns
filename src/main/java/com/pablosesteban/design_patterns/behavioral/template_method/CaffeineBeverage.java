/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.template_method;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: TEMPLATE METHOD
    is all about creating a template for an algorithm (a set of steps)

    defines the skeleton of an algorithm in a method, deferring some steps to subclasses, i.e. letting subclasses redefine certain
    steps of an algorithm without changing the algorithm’s structure (maximizes reuse among the subclasses)

    the algorithm is decoupled from the actual implementation of each specific operations

    ensures the algorithm’s structure stays unchanged, while subclasses provide some part of the implementation
*/
public abstract class CaffeineBeverage {
    /*
    TEMPLATE METHOD
        controls the algorithm but at certain points in the algorithm, it lets the subclass supply the implementation of the steps
        
        must be declared FINAL in order to prevent subclasses from reworking the sequence of steps in the algorithm and concentrate
        knowledge about the algorithm in one class
    */
    protected final void prepareBeverage() {
        //ALGORITHM
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    
    // common operations of the algorithm
    protected void boilWater() {
        System.out.println("Boiling water");
    }
    
    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }
    
    // some steps are abstract (specific operations)
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
