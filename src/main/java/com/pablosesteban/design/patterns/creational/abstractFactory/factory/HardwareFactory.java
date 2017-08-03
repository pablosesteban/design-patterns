/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.abstractFactory.factory;

import com.pablosesteban.design.patterns.creational.abstractFactory.product.MMU;
import com.pablosesteban.design.patterns.creational.abstractFactory.product.CPU;

/**
 *
 * @author psantamartae
 */

/*
ABSTRACT FACTORY CLASS
    declares and interface for operations that create abstract product objects
*/
public abstract class HardwareFactory {
    /*
    IMPLEMENTATION ISSUE: FACTORIES AS SINGLETONS
        an application usually needs only one instance of a concrete factory per product family
    */
    private static final EmberHardwareFactory EMBER_HARDWARE_FACTORY = new EmberHardwareFactory();
    private static final EginolaHardwareFactory EGINOLA_HARDWARE_FACTORY = new EginolaHardwareFactory();
    
    /*
    in this case we create a static method to get the concrete factory
    
    then we create abstract methods to create each product which will be created by the corresponding concrete factory class
    */
    public static HardwareFactory getFactory(Architecture arch) {
        switch(arch) {
            case EGINOLA:
                return EGINOLA_HARDWARE_FACTORY;
            case EMBER:
                return EMBER_HARDWARE_FACTORY;
            default:
                throw new EnumConstantNotPresentException(Architecture.class, arch.toString());
        }
    }
    
    /*
    IMPLEMENTATION ISSUE: CREATING PRODUCTS
        abstract factory only declares the interface for creating products, it is up to concrete factory classes to actually create them
    
        another common way to do it, is to define a factory method (FACTORY METHOD design pattern) for each product and then the concrete factory will specify its products by overriding the factory method for each
    */
    public abstract CPU createCPU();
    public abstract MMU createMMU();
    
}
