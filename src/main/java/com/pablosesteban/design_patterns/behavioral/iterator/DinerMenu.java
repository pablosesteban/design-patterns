/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class DinerMenu {
    private List<MenuItem> items;

    public DinerMenu() {
        items = new ArrayList<>();
    }

    // this method exposes the internal implementation
//    public List<MenuItem> getItems() {
//        return items;
//    }
    
    /*
    the client
        doesn’t need to know how the items in the collection are maintained nor does it need to know how the Iterator is implemented

        just needs to use the Iterator to step through the items in the collection
    */
    public Iterator<MenuItem> iterator() {
        return new DinerMenuIterator(items);
    }
    
    public void addItem(String name, String description, boolean vegetarian, double price) {
        items.add(new MenuItem(name, description, price, vegetarian));
    }
    
    public static void main(String[] args) {
        DinerMenu menu = new DinerMenu();
        
        menu.addItem("K&B’s Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
        menu.addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
        menu.addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
        menu.addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
        
        for (Iterator iterator = menu.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}
