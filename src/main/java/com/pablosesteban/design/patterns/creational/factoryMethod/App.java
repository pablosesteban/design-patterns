/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factoryMethod;

import com.pablosesteban.design.patterns.creational.factoryMethod.factory.AbstractLogger;
import com.pablosesteban.design.patterns.creational.factoryMethod.factory.JSONLoggerCreator;
import com.pablosesteban.design.patterns.creational.factoryMethod.factory.XMLLoggerCreator;
import com.pablosesteban.design.patterns.creational.factoryMethod.product.Logger;

/**
 *
 * @author psantamartae
 */

/*
FACTORY METHOD DESIGN PATTERN
    defines an interface for creating an object, but lets subclasses decide which class to instantiate (defers instantiation to its subclasses)

    it is used when
        a class cannnot anticipate the class of objects it must create (frameworks)
        
        a class wants its subclasses to specify the objects it creates

        classes delegate responsibility to one of several helper subclases and you want to localize the knowledge of which helper subclass is the delegate

    eliminates the need to bind application-specific classes into your code, it only deals with the Product interface

    provides a more flexible way than creating an object directly

    connects parallel class hierarchies which result when a class delegates some of its responsibilities to a separate class
        the factory method is not going to be called from the creator class but from its subclasses

        the factory method localizes knowledge of which classes belong together

    ABSTRACT FACTORY DESIGN PATTERN is often implemented with factory methods
*/

// CLIENT CLASS
public class App {
    
    private void logging(AbstractLogger abstractLogger, String message) {
        Logger logger = abstractLogger.getLogger();
        
        logger.log(message);
    }
    
    public static void main(String[] args) {
        AbstractLogger xmlLogger = new XMLLoggerCreator();
        AbstractLogger jsonLogger = new JSONLoggerCreator();
        
        App app = new App();
        
        app.logging(xmlLogger, "hola mundo");
        
        app.logging(jsonLogger, "hola mundo");
    }
}
