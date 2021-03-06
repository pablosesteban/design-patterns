/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.composite;

import java.util.Iterator;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class NullIterator implements Iterator<MenuComponent> {

    // always returns false
    @Override
    public boolean hasNext() {
        return false;
    }

    // always returns null
    @Override
    public MenuComponent next() {
        return null;
    }
    
}
