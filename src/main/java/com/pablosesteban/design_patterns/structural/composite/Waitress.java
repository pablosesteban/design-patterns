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

/*
DESIGN PATTERN: COMPOSITE
    allows you to compose objects into tree structures to represent part-whole hierarchies and lets clients treat individual
    objects (leaf) and compositions of objects (composite) uniformly
    
    allows us to build structures of objects in the form of trees that contain both compositions of objects and individual objects as nodes

    using a composite structure, we can apply the same operations over both composites and individual objects, i.e. in most 
    cases we can ignore the differences between compositions of objects and individual objects

    we could say that the this pattern takes the Single Responsibility design principle and trades it for TRANSPARENCY
        by allowing the Component interface to contain the child management operations and the leaf operations, a client can
        treat both composites and leaf nodes uniformly, so whether an element is a composite or leaf node becomes transparent to the client

        we lose a bit of safety because a client might try to do something inappropriate or meaningless on an element (like
        adding a child to a leaf object) but this is a tradeoff because of the design decision (you can shift your
        perspective and see a leaf as a node with zero children)
*/

// CLIENT
public class Waitress {
    // the top level component, the one that contains all the other components (leaf or composite)
    private MenuComponent menus;
    
    public Waitress(Menu menus) {
        this.menus = menus;
    }
    
    // print the entire component hierarchy
    public void printMenu() {
        menus.print();
    }
    
    public void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = menus.iterator();
        
        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            
            // using try/catch for the program logic is not a good practice, but this time is a good option if we want TRANSPARENCY, i.e. treat leaf and composites in the same way
            try {
            if (component.isVegetarian()) {
                component.print();
                System.out.println();
            }
            }catch (UnsupportedOperationException uoe) {
                // do nothing, composite objects are throwing it in its isVegetarian() method
            }
        }
    }
    
    public static void main(String[] args) {
        Menu menus = new Menu("MENUS", "All menus");
        
        MenuComponent breakfastMenu = new Menu("BREAKFAST", "Breakfast menu");
        MenuComponent lunchMenu = new Menu("LUNCH", "Lunch menu");
        MenuComponent dessertMenu = new Menu("DESSERT", "Dessert menu");
        MenuComponent dinerMenu = new Menu("DINNER", "Dinner menu");
        
        breakfastMenu.add(new MenuItem("K&B’s Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99));
        breakfastMenu.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99));
        breakfastMenu.add(new MenuItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49));
        breakfastMenu.add(new MenuItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59));
        
        dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", true, 1.59));
        
        lunchMenu.add(new MenuItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99));
        lunchMenu.add(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.65));
        lunchMenu.add(new MenuItem("Burrito", "“A large burrito, with whole pinto beans, salsa, guacamole", true, 4.49));
        lunchMenu.add(dessertMenu);
        
        dinerMenu.add(new MenuItem("Vegetarian BLT", "(Fakin’) Bacon with lettuce & tomato on whole wheat", true, 3.29));
        dinerMenu.add(new MenuItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.05));
        dinerMenu.add(new MenuItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.49));
        dinerMenu.add(dessertMenu);
        
        menus.add(breakfastMenu);
        menus.add(lunchMenu);
        menus.add(dinerMenu);
        
        Waitress w = new Waitress(menus);
        w.printMenu();
        w.printVegetarianMenu();
    }
}
