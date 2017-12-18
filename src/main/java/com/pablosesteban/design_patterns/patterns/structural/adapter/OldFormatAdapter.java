/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.structural.adapter;

import com.pablosesteban.design_patterns.patterns.structural.adapter.legacy.OldFormat;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
ADAPTER CLASS
    is the interface your client expects to see

    translates the request from client using the adaptee interface

    must implement the interface of the type you’re adapting to (target interface)

    must hold a reference (composition) to the object that we are adapting (adaptee interface)

    must implement all the methods in the target interface delegating in the adaptee interface
*/
public class OldFormatAdapter implements NewFormat {
    private OldFormat oldFormat;
    
    public OldFormatAdapter(OldFormat oldFormat) {
        this.oldFormat = oldFormat;
    }
    
    @Override
    public void play() {
        oldFormat.playFile();
    }

    @Override
    public String toString() {
        return "OldFormatAdapter{" + "oldFormat=" + oldFormat + '}';
    }
    
}
