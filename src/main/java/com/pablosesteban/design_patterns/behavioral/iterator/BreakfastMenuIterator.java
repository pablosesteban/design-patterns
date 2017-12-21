/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: ITERATOR
    relies on an interface called Iterator (JDK supplies one) which encapsulates the iteration
*/
public class BreakfastMenuIterator implements Iterator<MenuItem> {
    private MenuItem[] items;
    private int idx;

    public BreakfastMenuIterator(MenuItem[] items) {
        this.items = items;
    }
    
    @Override
    public boolean hasNext() {
        return idx < items.length && items[idx] != null;
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        
        return items[idx++];
    }
    
    // optional
    @Override
    public void remove() {
        if (idx <= 0) {
            throw new IllegalStateException();
        }
        
        if (items[idx-1] != null) {
            for (int i = idx-1; i < items.length-1; i++) {
                items[i] = items[++i];
            }
            
            items[items.length-1] = null;
        }
    }
    
}
