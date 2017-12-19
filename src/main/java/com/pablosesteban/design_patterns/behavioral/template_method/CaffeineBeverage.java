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

/*
DESIGN PRINCIPLE: don't call us, we'll call you (Hollywood Principle)
    gives us a way to prevent “dependency rot”, i.e when you have high-level components depending on low-level components depending on
    high-level components depending... no one can easily understand the way a system is designed

    this principle allow low-level components to hook themselves into a system, but the high-level components determine when they are needed, and how
/*
ABSTRACT CLASS
    defines and controls the algorithm

    implements common steps of the algorithm
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
        
        // the hook methods control a certain part of the algorithm
        if (hasCondiments()) {
            addCondiments();
        }
    }
    
    /*
    common operations of the algorithm
    
    declared FINAl in order to prevent subclasses to change it, as they should be the SAME for all those
    */
    protected final void boilWater() {
        System.out.println("Boiling water");
    }
    
    protected final void pourInCup() {
        System.out.println("Pouring into cup");
    }
    
    /*
    ABSTRACT METHODS
        to provided specific operations
    
        use them for the steps of the algorithm that MUST be implemented in each subclass (specific)
    */
    protected abstract void brew();
    protected abstract void addCondiments();
    
    /*
    HOOK METHODS
        concrete methods that are declared NOT FINAL in the abstract class and are only given an empty or default implementation
    
        give subclasses the ability to “hook into” the algorithm at various points if they wish by OVERRIDING them, but a subclass is also free to ignore the hook by NOT OVERRIDING them
    
        can be used to conditionally control the flow of the algorithm in the abstract class
    
        use them for parts of the algorithm that are optional
    */
    protected boolean hasCondiments() {
        // default implementation
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println("-------Preparing Tea-------");
        Tea tea = new Tea();
        tea.prepareBeverage();
        
        System.out.println("-------Preparing Coffee-------");
        Coffee coffee = new Coffee();
        coffee.prepareBeverage();
        
        System.out.println("-------Preparing Coffee with Sugar and Milk-------");
        coffee.setHasCondiments(true);
        coffee.prepareBeverage();
    }
    
}
