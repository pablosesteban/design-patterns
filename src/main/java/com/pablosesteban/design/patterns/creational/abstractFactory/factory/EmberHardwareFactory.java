/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.abstractFactory.factory;

import com.pablosesteban.design.patterns.creational.abstractFactory.product.EmberMMU;
import com.pablosesteban.design.patterns.creational.abstractFactory.product.EmberCPU;
import com.pablosesteban.design.patterns.creational.abstractFactory.product.MMU;
import com.pablosesteban.design.patterns.creational.abstractFactory.product.CPU;

/**
 *
 * @author psantamartae
 */

/*
CONCRETE FACTORY CLASS
    implements the operations to create concrete product objects
*/
public class EmberHardwareFactory extends HardwareFactory {
    @Override
    public CPU createCPU() {
        return new EmberCPU();
    }

    @Override
    public MMU createMMU() {
        return new EmberMMU();
    }
    
}
