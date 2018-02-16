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
}
