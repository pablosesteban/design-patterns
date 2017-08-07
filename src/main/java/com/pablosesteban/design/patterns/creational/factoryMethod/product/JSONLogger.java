/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factoryMethod.product;

import com.pablosesteban.design.patterns.creational.factoryMethod.product.Logger;

/**
 *
 * @author psantamartae
 */

/*
CONCRETE PRODUCT CLASS
    implements the product interface
*/
public class JSONLogger implements Logger {
    @Override
    public void log(String message) {
        StringBuilder jsonMessage = new StringBuilder();
        
        jsonMessage.append("{message: ");
        jsonMessage.append(message);
        jsonMessage.append("}");
        
        System.err.println(jsonMessage);
    }
    
}
