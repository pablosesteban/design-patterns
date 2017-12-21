/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.iterator;

import java.util.Iterator;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class BreakfastMenu {
    private MenuItem[]items;
    private int size;

    public BreakfastMenu(int size) {
        items = new MenuItem[size];
    }
    
    // this method exposes the internal implementation
//    public MenuItem[] getItems() {
//        return items;
//    }
    
    /*
    the client
        doesn’t need to know how the items in the collection are maintained nor does it need to know how the Iterator is implemented

        just needs to use the Iterator to step through the items in the collection
    */
    public Iterator<MenuItem> iterator() {
        return new BreakfastMenuIterator(items);
    }
    
    public void addItem(String name, String description, boolean vegetarian, double price) {
        if (size >= items.length) {
            throw new IllegalArgumentException("Menu is full");
        }
        
        items[size++] = new MenuItem(name, description, price, vegetarian);
    }
    
    public static void main(String[] args) {
        BreakfastMenu menu = new BreakfastMenu(10);
        
        menu.addItem("K&B’s Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
        menu.addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
        menu.addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
        menu.addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
        
        for (Iterator iterator = menu.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
    
}
