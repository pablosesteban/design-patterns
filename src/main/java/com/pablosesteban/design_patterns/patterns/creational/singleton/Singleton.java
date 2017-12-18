/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.creational.singleton;

/**
 *
 * @author psantamartae
 */

/*
DESIGN PATTERN: SINGLETON
    ensures a class only has ONE instance and provide a global point of access to it from the client

    sometimes it's important for some classes to have exactly one instance (an object that contains registry settings, etc...)

    the best way to deal with this, is to make the class itself responsible for keeping track of its sole instance

    the singleton has strict control over how and when clients access it

    avoids polluting the namespace with global variables that store sole instances

    the singleton class may be subclassed permitting refinement of operations and representation

    makes it easy to change your mind and allow more than one instance, so you can control the number of instances the application uses

    is more flexible than static methods (which are another way of package a singleton's funcionality)
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
    
        PRIVATE STATIC VOLATILE VARIABLE
            which holds the unique instance
    
            VOLATILE:
                in a multithreaded application where the threads operate on non-volatile variables, each thread may copy variables
                from main memory into a CPU cache while working on them for performance reasons, and if your computer contains more
                than one CPU, each thread may run on a different CPU
    
                mark a Java variable as "being stored in main memory"
    
                every read of a volatile variable will be read from the computer's main memory and not from the CPU cache, and that
                every write to a volatile variable will be written to main memory, and not just to the CPU cache
    
                guarantees visibility of changes to variables across threads
    
        PUBLIC STATIC METHOD
            which has access to the static variable and ensures that it is initialized with the unique instance before returning it
    
        EAGER INITIALIZATION: private static Singleton instance = new Singleton()
            sometimes it is not enough to define the singleton as a global (static) variable and rely on automatic initialization
            
            we might not have enough information to instantiate it at static initialization time
    
            it forces singletons to be created whether they are used or not when the class is loaded
    
            this way is guaranteed to be thread safe, JVM guarantees that the instance will be created before any thread accesses the static instance variable
    */
    private static volatile Singleton instance;
    
    private Singleton(){};
    
    /*
    LAZY INITIALIZATION: cretion of the instance in the first use
    
    THREAD SAFE implementation using the DOUBLE-CHECKED LOCKING
        used to avoid obtaining the lock everytime the code is executed keeping your code fast in a multi-threaded environment and saving resources
        
        the only time synchronization is relevant is the first time through this method, i.e.
            once we’ve set the unique instance variable to an instance of Singleton, we have no further need to synchronize this method
            
            after the first time through, synchronization is totally unneeded overhead!
    
        if the call are not happening together then the first condition will fail and the code execution will not execute the locking
    
        synchronizing a method can decrease performance by a factor of 100, so if a high traffic part of your code begins using getInstance() is important to use this technique
    
        doesn’t work in Java 1.4 or earlier as many JVMs contain implementations of the volatile keyword that allow improper synchronization for double-checked locking
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
