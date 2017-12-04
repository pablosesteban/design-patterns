/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.adapter;

import com.pablosesteban.design.patterns.structural.adapter.legacy.OldFormat;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
ADAPTER CLASS
    
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
    
}
