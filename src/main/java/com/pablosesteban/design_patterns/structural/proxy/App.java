/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.proxy;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: PROXY
    provides a surrogate or placeholder for another object to control access to it

    there are many variations of the pattern
        Remote Proxy: controls access to a remote object (object that lives in a different JVM)

        Virtual Proxy: controls access to a resource that is expensive to create

        Protection Proxy: controls access to a resource based on access rights

    use the Proxy Pattern to create a representative object that controls access to another object
*/
public class App {
    public static void main(String[] args) {
        IvoryTowerProxy proxy = new IvoryTowerProxy(new IvoryTower());
        
        proxy.enter(new Wizard("Black Wizard"));
        proxy.enter(new Wizard("Red Wizard"));
        proxy.enter(new Wizard("White Wizard"));
        proxy.enter(new Wizard("Yellow Wizard"));
    }
}
