/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factory.abstractFactory.product.sauce;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class MarinaraSauce implements Sauce {
    private final String name = "Marinara Sauce";
    
    public String getName() {
        return name;
    }
    
}
