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
public class EginolaMMU extends MMU {
    String name = "Eginola MMU";

    public EginolaMMU() {
        super.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
