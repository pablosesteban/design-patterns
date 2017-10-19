/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DECORATOR that converts all uppercase characters to lowercase in the input stream
*/
public class LowerCaseInputStream extends FilterInputStream {
    public LowerCaseInputStream(InputStream is) {
        super(is);
    }
    
    @Override
    public int read() throws IOException {
        return 0;
    }
}
