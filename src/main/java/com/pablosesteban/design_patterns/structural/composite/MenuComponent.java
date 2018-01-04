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
COMPONENT INTERFACE
    defines an interface for all objects in the composition: both the composite and the leaf nodes

    all components must implement this interface; however, because leaves and composite have different roles we
    can’t always define a default implementation for each method that makes sense, sometimes the best you can do
    is throw a RuntimeException and then overriding those that make sense in each subclass
*/
public abstract class MenuComponent {
    protected String name;
    protected String description;

    // "operation" methods: used by leaf objects, but also some of them by composite obejcts
    public String getName() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public String getDescription() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public double getPrice() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException("Operation not supported");
    }
    
    public void print() {
        throw new UnsupportedOperationException("Operation not supported");
    }
    
    // "composite" methods: methods for manipulating the components
    public void add(MenuComponent component) {
        throw new UnsupportedOperationException("Operation not supported");
    }
    
    public void remove(MenuComponent component) {
        throw new UnsupportedOperationException("Operation not supported");
    }
    
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public abstract Iterator iterator();
    
    @Override
    public int hashCode() {
        int result = 17;
        
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || !(obj instanceof MenuComponent)) {
            return false;
        }
        
        final MenuComponent menuComponent = (MenuComponent) obj;
        
        return name.equals(menuComponent.getName()) && description.equals(menuComponent.getDescription());
    }
}
