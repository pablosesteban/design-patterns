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
CONCRETE DECORATOR that converts all uppercase characters to lowercase in the input stream

FilterInputStream is the ABSTRACT DECORATOR
*/
public class LowerCaseInputStream extends FilterInputStream {
    public LowerCaseInputStream(InputStream is) {
        // COMPOSITION (handling by the abstract decorator)
        super(is);
    }
    
    @Override
    public int read() throws IOException {
        // DELEGATION
        char c = (char) super.read();
        
        return c == -1 ? c : Character.toLowerCase(c);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int numberOfBytes = super.read(b, off, len);
        
        for(int i = 0; i < len; i++) {
            
        }
        
        return 0;
    }

    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
