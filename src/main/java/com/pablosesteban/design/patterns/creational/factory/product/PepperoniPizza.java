/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.product;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
/*
CONCRETE PRODUCT
    needs to implement the product interface so it can be created by the factory and handed back to the client
*/

public class PepperoniPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Pepperoni Pizza...");
    }
    
}
