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
REAL SUBJECT CLASS
    is usually the object that does most of the real work
    
    the Proxy controls access to it
*/
public class IvoryTower implements WizardTower {
    private static final Logger LOGGER = Logger.getLogger(IvoryTower.class.getName());
    
    @Override
    public void enter(Wizard w) {
        LOGGER.info(w + " enter the tower");
    }
    
}
