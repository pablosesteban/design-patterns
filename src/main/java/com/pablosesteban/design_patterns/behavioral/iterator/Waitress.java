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
public class Waitress {
    private BreakfastMenu breakfastMenu;
    private DinerMenu dinerMenu;
    
    public Waitress(BreakfastMenu breakfastMenu, DinerMenu dinerMenu) {
        this.breakfastMenu = breakfastMenu;
        this.dinerMenu = dinerMenu;
    }
    
    // the Iterator allows the Waitress to be decoupled from the actual implementation of the concrete classes
    public void printMenu() {
        System.out.println("----------BREAKFAST----------");
        printMenu(breakfastMenu.iterator());
        
        System.out.println("----------DINER----------");
        printMenu(dinerMenu.iterator());
    }
    
    private void printMenu(Iterator<MenuItem> it) {
        // a loop that polymorphically handles any collection of items as long as it implements Iterator interface
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public static void main(String[] args) {
        BreakfastMenu breakfastMenu = new BreakfastMenu(10);
        breakfastMenu.addItem("K&B’s Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
        breakfastMenu.addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
        breakfastMenu.addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
        breakfastMenu.addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
        
        DinerMenu dinerMenu = new DinerMenu();
        dinerMenu.addItem("Vegetarian BLT", "(Fakin’) Bacon with lettuce & tomato on whole wheat", true, 3.29);
        dinerMenu.addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.05);
        dinerMenu.addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.49);
        dinerMenu.addItem("Steamed Veggies and Brown Rice", "Steamed vegetables over brown rice", true, 3.99);
        dinerMenu.addItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89);
        
        Waitress w = new Waitress(breakfastMenu, dinerMenu);
        w.printMenu();
    }
}
