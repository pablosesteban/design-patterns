/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.strategy.duck;

import com.pablosesteban.design_patterns.behavioral.strategy.behavior.fly.FlyBehavior;
import com.pablosesteban.design_patterns.behavioral.strategy.behavior.quack.QuackBehavior;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
INHERITANCE:
    putting quack and fly methods inside the parent class of all ducks with a common implementation

    has not turned out well for REUSING when it comes to MAINTENANCE

    duck behavior keeps changing across the subclasses

INTERFACES:
    removing quack and fly methods from Duck class and put them in Quackable and Flyable interfaces so Duck subclasses can implement them

    interfaces have NO implementation code, so NO CODE REUSE

    whenever you need to to modify a behavior, you have to modify it in all subclasses implementing it (BUGS)

DESIGN PRINCIPLE: identify the aspects of your application that vary and separate them from what stays the same
    over time an application must grow and CHANGE or it will DIE
    
    take parts that vary and encapsulate them, so that later you can alter or extend it without affecting those that don't (FLEXIBILITY)

    in this case, create a separate set of classes for each behavior whose entire reason for living is to represent the behavior
*/
public abstract class Duck {
    // not all ducks quacks!
//    public void quack() {
//        System.out.println("QUACKING");
//    }
    
    // not all ducks flies!
//    public void fly() {
//        System.out.println("FLYING!");
//    }
    
    /*
    DESIGN PRINCIPLE: program to an interface, not to an implementation
        the point is to exploit POLYMORPHISM by programming to a SUPERTYPE so that the actual runtime object isn't locked into the code
    
        the declared type of the variables should be a supertype, usually an abstract class or interface, so that the objects assigned to
        those variables can be of any concrete implementation of the supertype, which means the class declaring them doesn't have to know
        about the actual object types
    */
    /*
    DESIGN PRINCIPLE: favor composition over inheritance
        creating systems using composition gives you a lot more flexibility
    
        lets you encapsulates a family of algorithms into their own set of classes
    
        lets you change the behavior at runtime as long as the object you are composing with implements the correct interface
    */
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    
    /*
    DELEGATION:
        rather than handling the fly and quack behavior itself, the Duck object DELEGATES that behavior to the objects referenced to this purpose
    
        just allows those objects perform the behaviors for it
    
        Duck objects doesn't care what kind of objects they are, all he cares about is that they how to fly and quack
    */
    public void performFly() {
        flyBehavior.fly();
    }
    
    public void performQuack() {
        quackBehavior.quack();
    }
    
    public void swim() {
        System.out.println("SWIMMING!");
    }
    
    /*
    in order to change the behaviors at runtime
    
    we couldn't do that if the implementation lives inside the Duck class (inheritance)
    */
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }
    
    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
    
    public abstract void display();
    
}
