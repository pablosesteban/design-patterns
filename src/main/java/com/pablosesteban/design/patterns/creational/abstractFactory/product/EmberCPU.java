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
CONCRETE PRODUCT CLASS
    defines a product object to be created by the corresponding concrete factory

    must implements the abstract product interface
*/
public class EmberCPU extends CPU {
    String name = "Ember CPU";

    public EmberCPU() {
        super.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
