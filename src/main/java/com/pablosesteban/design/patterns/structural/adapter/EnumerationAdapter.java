/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

// implements target interface
public class EnumerationAdapter implements Iterator<Object> {
    // adaptee
    private Enumeration<Object> enumeration;
    
    public EnumerationAdapter(Enumeration enumeration) {
        this.enumeration = enumeration;
    }
    
    // delegating on adaptee interface
    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    // delegating on adaptee interface
    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    // Enumeration just doesn’t support remove, it’s a “read only” interface so the best we can do is throw a runtime exception
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
}
