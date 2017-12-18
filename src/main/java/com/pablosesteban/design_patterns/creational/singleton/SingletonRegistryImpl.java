/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.creational.singleton;

import java.util.logging.Logger;

/**
 *
 * @author psantamartae
 */
public class SingletonRegistryImpl extends SingletonRegistry {
    /*
    IMPLEMENTATION ISSUE: WHERE DO SINGLETON CLASSES REGISTER THEMSELVES
        a possibility is in their constructor
    
        the drawback is that instances of all possible Singleton subclasses must be created, or else they won't get registered
    */
    protected SingletonRegistryImpl() {
        register(this.getClass().getCanonicalName(), this);
        
        Logger.getLogger(SingletonRegistryImpl.class.getName()).info("Registered singleton " + SingletonRegistryImpl.class.getName());
    }
    
}
