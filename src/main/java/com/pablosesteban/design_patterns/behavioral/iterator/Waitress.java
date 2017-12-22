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

// CLIENT
public class Waitress {
    private Menu breakfastMenu;
    private Menu dinnerMenu;
    private Menu lunchMenu;
    
    public Waitress(Menu breakfastMenu, Menu dinnerMenu, Menu lunchMenu) {
        this.breakfastMenu = breakfastMenu;
        this.dinnerMenu = dinnerMenu;
        this.lunchMenu = lunchMenu;
    }
    
    // the Iterator allows the Waitress to be decoupled from the actual implementation of the concrete classes
    public void printMenu() {
        System.out.println("----------BREAKFAST----------");
        printMenu(breakfastMenu.iterator());
        
        System.out.println("----------LUNCH----------");
        printMenu(lunchMenu.iterator());
        
        System.out.println("----------DINNER----------");
        printMenu(dinnerMenu.iterator());
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
        
        LunchMenu lunchMenu = new LunchMenu();
        lunchMenu.addItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99);
        lunchMenu.addItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.65);
        lunchMenu.addItem("Burrito", "“A large burrito, with whole pinto beans, salsa, guacamole", true, 4.49);
        
        DinnerMenu dinerMenu = new DinnerMenu();
        dinerMenu.addItem("Vegetarian BLT", "(Fakin’) Bacon with lettuce & tomato on whole wheat", true, 3.29);
        dinerMenu.addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.05);
        dinerMenu.addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.49);
        dinerMenu.addItem("Steamed Veggies and Brown Rice", "Steamed vegetables over brown rice", true, 3.99);
        dinerMenu.addItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89);
        
        Waitress w = new Waitress(breakfastMenu, dinerMenu, lunchMenu);
        w.printMenu();
    }
}
