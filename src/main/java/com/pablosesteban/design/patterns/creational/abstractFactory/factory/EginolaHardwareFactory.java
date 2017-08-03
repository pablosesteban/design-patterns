/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.abstractFactory.factory;

import com.pablosesteban.design.patterns.creational.abstractFactory.product.EginolaCPU;
import com.pablosesteban.design.patterns.creational.abstractFactory.product.EginolaMMU;
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
public class EginolaHardwareFactory extends HardwareFactory {
    @Override
    public CPU createCPU() {
        return new EginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EginolaMMU();
    }
    
}
