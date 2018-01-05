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

/*
EXTERNAL ITERATOR
    the client controls the iteration by calling next() to get the next element

    must maintain its position in the iteration so that an outside client can drive the iteration by calling hasNext() and next() methods

    it iterates over a Composite object and of making sure all the child composites (and child child composite, and so on) are included
*/
public class CompositeIterator implements Iterator<MenuComponent> {
    // we need to maintain the position over the composite recursive structure using a Stack which has only the iterators of a composite child
    private Stack<Iterator<MenuComponent>> stack = new Stack<>();
    
    // the iterator of the top level composite we’re going to iterate over is passed in and thrown into the stack
    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }
    
    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        
        // get the iterator off the TOP (doesn't remove it)
        Iterator<MenuComponent> iterator = stack.peek();
        
        if (!iterator.hasNext()) {
            // get the iterator off the TOP (removing it)
            stack.pop();
            
            return hasNext();
        }else {
            return true;
        }
    }

    @Override
    public MenuComponent next() {
        if (!hasNext()) {
            return null;
        }
        
        Iterator<MenuComponent> iterator = stack.peek();
        MenuComponent component = iterator.next();
        
        // only if the component is a composite it needs to be included in the iteration
        if (component instanceof Menu) {
            stack.push(component.iterator());
        }
        
        return component;
    }
    
}
