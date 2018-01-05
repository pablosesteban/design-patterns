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

    two kinds of iterators
        EXTERNAL: the client controls the iteration by calling next() to get the next element

        INTERNAL: the iteration is controlled by the iterator itsel, so you have to tell the iterator what to do with those elements as it goes through them (less flexible)

    Iterators imply no iteration ordering
*/

/*
DESIGN PRINCIPLE: a class should have only one reason to change (Single Responsibility)
    when you allow a class to not only take care of its own business (like managing some kind of aggregate) but also take on more
    responsibilities (like iteration) then we’ve given the class two reasons to CHANGE

    the principle guides us to assign each responsibility to one class, and only one class (one of the most difficult things to do)

    COHESION
        a is a more general concept concept than this principle that measure of how closely a class or
        a module supports a single purpose or responsibility

        can be HIGH when it is designed around a set of related functions, or LOW when it is designed
        around a set of unrelated functions

    classes that adhere to the principle tend to have high cohesion and are more maintainable
*/

// CONCRETE ITERATOR (ABSTRACT ITERATOR is java.util.Iterator) it is an EXTERNAL ITERATOR
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
