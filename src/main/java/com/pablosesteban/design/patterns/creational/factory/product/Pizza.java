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
PRODUCT
    this is the product of the factory

    abstract product for all products
*/
public abstract class Pizza {
    public abstract void prepare();
    
    public void bake() {
        System.out.println("Baking...");
    }
    
    public void cut() {
        System.out.println("Cutting...");
    }
    
    public void box() {
        System.out.println("Boxing...");
    }
    
}
