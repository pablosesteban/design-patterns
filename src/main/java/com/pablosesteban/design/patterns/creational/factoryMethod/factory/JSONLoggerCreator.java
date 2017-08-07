/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factoryMethod.factory;

import com.pablosesteban.design.patterns.creational.factoryMethod.product.JSONLogger;
import com.pablosesteban.design.patterns.creational.factoryMethod.product.Logger;

/**
 *
 * @author psantamartae
 */
public class JSONLoggerCreator extends AbstractLogger {
    @Override
    Logger createLogger() {
        return new JSONLogger();
    }
    
}
