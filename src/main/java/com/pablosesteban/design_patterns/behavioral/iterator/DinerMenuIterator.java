/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: ITERATOR
    relies on an interface called Iterator (JDK supplies one) with at least two methods: hasNext() and next()
*/
public class DinerMenuIterator implements Iterator<MenuItem> {
    private List<MenuItem> items;
    private int idx;

    public DinerMenuIterator(List<MenuItem> items) {
        this.items = items;
    }
    
    @Override
    public boolean hasNext() {
        return idx < items.size();
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        
        return items.get(idx++);
    }
    
}
