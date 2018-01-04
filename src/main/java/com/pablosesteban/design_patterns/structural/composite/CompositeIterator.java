/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.composite;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

// iterator which iterates over the Composite objects in the tree, and of making sure all the child composite (and child child composite, and so on) are included
public class CompositeIterator implements Iterator<MenuComponent> {
    private Stack stack = new Stack();
    
    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }
    
    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MenuComponent next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
