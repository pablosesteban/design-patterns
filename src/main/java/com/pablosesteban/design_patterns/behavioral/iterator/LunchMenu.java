/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.iterator;

import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class LunchMenu implements Menu {
    // a Java Collection that supports Iterator
    private Hashtable items;
    
    public LunchMenu() {
        items = new Hashtable();
    }
    
    public void addItem(String name, String description, boolean vegetarian, double price) {
        items.put(name, new MenuItem(name, description, price, vegetarian));
    }
    
    @Override
    public Iterator<MenuItem> iterator() {
        return items.values().iterator();
    }
    
}
