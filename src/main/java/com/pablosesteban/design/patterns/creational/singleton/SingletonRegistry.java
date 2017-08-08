/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.singleton;

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
    private static SingletonRegistry instance;
    private static final Map<String, SingletonRegistry> REGISTRY = new HashMap<>();
    
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
    public static SingletonRegistry getInstance(String className) {
        instance = lookup(className);
        
        if (instance == null) {
            synchronized(SingletonRegistry.class) {
                if (instance == null) {
                    try {
                        instance = (SingletonRegistry) Class.forName(className).newInstance();
                    } catch (ClassNotFoundException cnfe) {
                        Logger.getLogger(SingletonRegistry.class.getName()).log(Level.SEVERE, "Couldn't find class " + className, cnfe);
                    } catch(InstantiationException ie) {
                        Logger.getLogger(SingletonRegistry.class.getName()).log(Level.SEVERE, "Couldn't instantiate an object of type " + className, ie);
                    } catch(IllegalAccessException ia) {
                        Logger.getLogger(SingletonRegistry.class.getName()).log(Level.SEVERE, "Couldn't access class " + className, ia);
                    }
                }
            }
        }
        
        return instance;
    }
    
    public static void main(String[] args) {
        SingletonRegistry instance1 = SingletonRegistry.getInstance("SingletonImpl1");
        SingletonRegistry instance2 = SingletonRegistry.getInstance("SingletonImpl1");
        
        System.out.println(instance1 == instance2);
    }
    
}
