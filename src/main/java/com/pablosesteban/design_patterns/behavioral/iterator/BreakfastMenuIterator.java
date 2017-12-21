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
    
}
