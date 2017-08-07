/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factoryMethod.factory;

import com.pablosesteban.design.patterns.creational.factoryMethod.product.Logger;

/**
 *
 * @author psantamartae
 */

/*
CREATOR CLASS
    declares de factory method which return an object of type product class

    relies on its subclasses to define the factory method so that it returns an instance of the appropriate concrete product class
*/

/*
IMPLEMENTATION ISSUE: CREATOR CLASS/INTERFACE
    class
        can provide a default implementation for its factory method

    interface
        cannot provide the default implementation for its factory method
*/
public abstract class AbstractLogger {
    /*
    IMPLEMENTATION ISSUE: FACTORY METHOD ABSTRACT/CONCRETE
        abstract
            creator class does not provide a default implementation for it
    
            requires subclasses to define an implementation because there is no default one
        
        concrete
            usually provides a default implementation for the product for flexibility
    */
    /*
    IMPLEMENTATION ISSUE: PARAMETRIZED FACTORY METHOD
        lets the method creates multiple kinds of products
    
        it takes a parameter (class identifier) that identifies the kind of object to create
    */
    abstract Logger createLogger();
    
    public Logger getLogger() {
        return createLogger();
    }
    
}
