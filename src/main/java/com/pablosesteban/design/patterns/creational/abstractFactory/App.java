/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.abstractFactory;

import com.pablosesteban.design.patterns.creational.abstractFactory.factory.Architecture;
import com.pablosesteban.design.patterns.creational.abstractFactory.factory.HardwareFactory;
import com.pablosesteban.design.patterns.creational.abstractFactory.product.CPU;
import com.pablosesteban.design.patterns.creational.abstractFactory.product.MMU;

/**
 *
 * @author psantamartae
 */

/*
ABSTRACT FACTORY DESIGN PATTERN
    provide an interface for creating families of related or dependent objects without specifying their concrete classes

    client only have to commit to an interface defined by an abstract class not a particular concrete class

    also enforces dependencies between the concrete classes, i.e. related objects are going to be created together

    used when a system should be independent of how its products are implemented or configure with one of a multiple families of products

    used when you want to hide the implementations

    usually a single instance of a concrete factory class is created at runtime, which creates objects having a particular implementation

    abstract factory defers creation of product objects to its concrete factory subclasses

    isolates concrete classes, i.e. product class names are isolated in the implementation of the concrete factory and do not appear in client code

    makes exchanging product families easy as the class of a concrete factory appears only once in the code (when it is instantiated), so you onle have to change it and the hole product family changes at once

    promotes consistency among product, i.e. only one kind of product at a time

    but supporting new kinds of products is difficult as the abstract factory interface fixes the set of product that can be created (PROTOTYPE design pattern)
*/

/*
CLIENT CLASS
    use only the interfaces declared by the AbstractFactory and AbstractProduct classes
*/
public class App {
    public static void main(String[] args) {
        HardwareFactory factory = HardwareFactory.getFactory(Architecture.EMBER);
        
        CPU cpu = factory.createCPU();
        MMU mmu = factory.createMMU();
        System.out.println(cpu);
        System.out.println(mmu);
        
        factory = HardwareFactory.getFactory(Architecture.EGINOLA);
        
        cpu = factory.createCPU();
        mmu = factory.createMMU();
        System.out.println(cpu);
        System.out.println(mmu);
    }
}
