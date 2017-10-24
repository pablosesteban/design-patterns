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
public class NYStylePepperoniPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing New York Style Pepperoni Pizza...");
    }
    
}
