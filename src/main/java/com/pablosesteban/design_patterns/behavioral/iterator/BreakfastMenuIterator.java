/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: ITERATOR
    provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation, i.e. how things are represented under the covers
    
    relies on an interface called Iterator (JDK supplies one) which encapsulates the iteration

    once you have a uniform way of accessing the elements of all your aggregate objects, you can write polymorphic code that works with any of these aggregates

    another important point is that it takes the responsibility of traversing elements and gives that responsibility to the iterator object,
    not the aggregate object and keeps the aggregate focused on the things it should be focused on (managing a collection of objects), not on iteration
*/

// CONCRETE ITERATOR (ABSTRACT ITERATOR is java.util.Iterator)
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
                items[i] = items[i+1];
            }
            
            items[items.length-1] = null;
            
            idx--;
        }
    }
    
}
