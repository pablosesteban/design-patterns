/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.abstractFactory.product;

/**
 *
 * @author psantamartae
 */

/*
ABSTRACT PRODUCT CLASS
    declares an interface for a type of product object
*/
public abstract class CPU {
    String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CPU{" + "name: " + name + '}';
    }
    
}
