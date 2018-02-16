/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.pablosesteban.design_patterns.structural.proxy;

import java.util.logging.Logger;

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

/*
PROXY CLASS
keeps a reference to the Subject, so it can forward requests to the Subject when necessary

often instantiates or handles the creation of the real subject (responsible for creating and destroying it)
*/
public class IvoryTowerProxy implements WizardTower {
    private static final Logger LOGGER = Logger.getLogger(IvoryTowerProxy.class.getName());
    
    private static final int NUM_MAX_WIZARD = 3;
    
    private int wizardNum;
    
    // real subject
    private IvoryTower ivoryTower;
    
    public IvoryTowerProxy(IvoryTower ivoryTower) {
        this.ivoryTower = ivoryTower;
    }
    
    @Override
    public void enter(Wizard w) {
        if (wizardNum < NUM_MAX_WIZARD) {
            // delegates on the real subject, but makes some logic before that
            ivoryTower.enter(w);
            
            ++wizardNum;
        }else {
            LOGGER.severe(w + " cannot enter, tower if full of wizards!");
        }
    }
    
    public static void main(String[] args) {
        IvoryTowerProxy proxy = new IvoryTowerProxy(new IvoryTower());
        
        proxy.enter(new Wizard("Black Wizard"));
        proxy.enter(new Wizard("Red Wizard"));
        proxy.enter(new Wizard("White Wizard"));
        proxy.enter(new Wizard("Yellow Wizard"));
    }
}
