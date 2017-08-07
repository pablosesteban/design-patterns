/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.factoryMethod.product;

/**
 *
 * @author psantamartae
 */

/*
CONCRETE PRODUCT CLASS
    implements the product interface
*/
public class XMLLogger implements Logger {
    @Override
    public void log(String message) {
        StringBuilder xmlMessage = new StringBuilder();
        
        xmlMessage.append("<message>");
        xmlMessage.append(message);
        xmlMessage.append("</message>");
        
        System.err.println(xmlMessage);
    }
    
}
