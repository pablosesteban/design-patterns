/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author psantamartae
 */

/*
IMPLEMENTATION ISSUE: SUBCLASSING THE SINGLETON CLASS
    the main issue is not so much defining the subclass but installing its unique instance so that clients will be able to use it

    the variable that refers to the singleton instance must get initialized with an instance of the subclass

    the more flexible way is to use a REGISTRY OF SINGLETONS
        the Singleton classes can register their singleton instance by name in a well-known registry
        
        all it requires is a common interface for all Singleton classes that includes operations for the registry

        no longer is the Singleton class responsible for creating the singleton, its primary responsibility is to make the singleton object of choice accessible in the system
*/
public class SingletonRegistry {
    private static final Logger LOGGER = Logger.getLogger(SingletonRegistry.class.getName());
    
    private static SingletonRegistry instance;
    private static final Map<String, SingletonRegistry> REGISTRY = new HashMap<>();
    
    // in order to subclass the singleton the constructor MUST be PROTECTED
    protected SingletonRegistry() {};
    
    // looks up the corresponding singleton and, if it exists, returns it or, if there's no such singleton, returns null
    protected static SingletonRegistry lookup(String name) {
        return REGISTRY.get(name);
    }
    
    // registers the Singleton instance
    public static void register(String name, SingletonRegistry instance) {
        REGISTRY.put(name, instance);
    }
    
    // consults the registry
    public static SingletonRegistry getInstance(String fullyQualifiedClassName) {
        instance = lookup(fullyQualifiedClassName);
        
        if (instance == null) {
            synchronized(SingletonRegistry.class) {
                LOGGER.info("Thread " + Thread.currentThread().getName() + " registers the singleton");
                
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ie) {
                    LOGGER.log(Level.SEVERE, "Thread " + Thread.currentThread().getName() + " interrupted", ie);
                }
                
                if (instance == null) {
                    try {
                        instance = (SingletonRegistry) Class.forName(fullyQualifiedClassName).newInstance();
                    } catch (ClassNotFoundException cnfe) {
                        LOGGER.log(Level.SEVERE, "Couldn't find class " + fullyQualifiedClassName, cnfe);
                    } catch(InstantiationException ie) {
                        LOGGER.log(Level.SEVERE, "Couldn't instantiate an object of type " + fullyQualifiedClassName, ie);
                    } catch(IllegalAccessException ia) {
                        LOGGER.log(Level.SEVERE, "Couldn't access class " + fullyQualifiedClassName, ia);
                    }
                }
            }
        }
        
        return instance;
    }
    
    public static void main(String[] args) {
        SingletonRegistry instance1 = SingletonRegistry.getInstance("com.pablosesteban.design.patterns.creational.singleton.SingletonRegistryImpl");
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonRegistry instance2 = SingletonRegistry.getInstance("com.pablosesteban.design.patterns.creational.singleton.SingletonRegistryImpl");
                
                System.out.println("instance2: " + instance2);
            }
        }).start();
        
        System.out.println("instance1: " + instance1);
    }
    
}
