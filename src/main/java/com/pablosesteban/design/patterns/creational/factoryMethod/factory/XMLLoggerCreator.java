/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factoryMethod.factory;

import com.pablosesteban.design.patterns.creational.factoryMethod.product.Logger;
import com.pablosesteban.design.patterns.creational.factoryMethod.product.XMLLogger;

/**
 *
 * @author psantamartae
 */

/*
CONCRETE CREATOR CLASS
    
*/
public class XMLLoggerCreator extends AbstractLogger {
    @Override
    Logger createLogger() {
        return new XMLLogger();
    }
    
}
