/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.singleton;

/**
 *
 * @author psantamartae
 */

/*
SINGLETON DESIGN PATTERN
    ensures a class only has ONE instance and provide a global point of access to it from the client

    sometimes it's important for some classes to have exactly one instance

    the best way to deal with this, is to make the class itself responsible for keeping track of its sole instance

    the singleton has strict control over how and when clients access it

    avoids polluting the name space with global variables that store sole instances

    the singleton class may be subclassed permitting refinement of operations and representation

    makes it easy to change your mind and allow more than one instance, so you can control the number of instances the application uses

    si more flexible than class operations (static methods which are another way of package a singleton's funcionality)
*/

/*
SINGLETON CLASS
    defines a getInstance method that lets clients access its unique instance

    is responsible for creating its own unique instance
*/
public class Singleton {
    /*
    IMPLEMENTATION ISSUE: ENSURING AN UNIQUE INSTANCE
        PRIVATE/PROTECTED CONSTRUCTOR
            in order not to allow create instances of the class from outside
    
            in order to make subclasses of the singleton
    
        PRIVATE STATIC VARIABLE
            which holds the unique instance
    
        PUBLIC STATIC METHOD
            which has access to the static variable and ensures that it is initialized with the unique instance before returning it
    
        sometimes it is not enough to define the singleton as a global variable and rely on automatic initialization
            we might not have enough information to instantiate it at static initialization time
    
            it forces singletons to be created whether they are used or not
            
    */
    private static volatile Singleton instance;
    
    private Singleton(){};
    
    /*
    LAZY INITIALIZATION: cretion of the instance in the first use
    
    THREAD SAFE implementation using the DOUBLE-CHECKED LOCKING
        used to avoid obtaining the lock everytime the code is executed keeping your code fast in a multi-threaded environment and saving resources
    
        if the call are not happening together then the first condition will fail and the code execution will not execute the locking
    */
    public static Singleton getInstance() {
        if (instance == null) {// FIRST CHECK
            synchronized(Singleton.class) {
                if (instance == null) {// SECOND CHECK (synchronized on class)
                    instance = new Singleton();
                }
            }
        }
        
        return instance;
    }
    
}
