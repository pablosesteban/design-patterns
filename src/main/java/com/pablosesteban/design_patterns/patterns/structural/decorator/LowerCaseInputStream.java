/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.structural.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
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
    
    /*
    reads the next byte of data from the input stream
    
    the byte is returned as an int in the range 0 to 255 or -1 if the end of the stream is reached
    */
    @Override
    public int read() throws IOException {
        // DELEGATION
        int c = super.read();
        
        return c == -1 ? c : Character.toLowerCase((char) c);
    }
    
    /*
    reads up to len bytes of data from the input stream and stores them into the buffer array b
    
    the first byte read is stored into element b[off], the next one into b[off+1], and so on
    
    returns the total number of bytes read into the buffer, or -1 if there is no more data because the end of the stream has been reached
    */
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        // DELEGATION
        int numberOfBytes = super.read(b, off, len);
        
        for(int i = off; i < off+numberOfBytes; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        
        return numberOfBytes;
    }
    
    // this method calls the above one in the way read(b, 0, b.length) so there is no need to override it!
    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b);
    }
    
    
    public static void main(String[] args) {
        int c = 0;
        
        InputStream is = null;
        try {
            is = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("src/main/resources/test.txt")));
            
            while ((c = is.read()) >= 0) {
                System.out.print((char)c);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                
            }
        }
    }
}
