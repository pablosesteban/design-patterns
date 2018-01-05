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
LEAF CLASS
    are the Component elements without children

    defines the behavior for the elements in the composition

    implements the operations the Composite supports
*/
public class MenuItem extends MenuComponent {
    protected double price;
    protected boolean vegetarian;
    
    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.vegetarian = vegetarian;
    }
    
    // only implements the "operation" methods
    @Override
    public void print() {
        // JSON-like representation
        System.out.print("MenuItem{" + "name='" + name + "', description='" + description + "', price=" + price + ", vegetarian=" + vegetarian + '}');
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + Boolean.hashCode(vegetarian);
        
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || !(obj instanceof MenuItem)) {
            return false;
        }
        
        final MenuItem menuItem = (MenuItem) obj;
        
        return name.equals(menuItem.getName()) && description.equals(menuItem.getDescription()) && price == menuItem.price && vegetarian == menuItem.isVegetarian();
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        // leaf objects has nothing to iterate over, so the best way to deal with is use the Null Object "design pattern" as all Components has to implement an iterator
        return new NullIterator();
    }
}
