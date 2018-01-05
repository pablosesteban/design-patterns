/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
COMPOSITE CLASS
    are the Component elements with children

    defines behavior of the components having children and stores child components

    can also implement some of the Leaf related operations
*/
public class Menu extends MenuComponent {
    // composite objects can have any number of children (leaf or composite) referenced by the component interface
    protected List<MenuComponent> children = new ArrayList<>();
    protected Iterator<MenuComponent> iterator;
    
    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    // "operation" methods
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /*
    because this class is a composite and contains both leaf and composite items, should print everything it contains recursively
    
    print not only the information about it, but all of its components
    */
    @Override
    public void print() {
        // JSON-like representation
        System.out.print("Menu{" + "name='" + name + "', description='" + description + "', items={");
        
        /*
        INTERNAL ITERATOR
            this kind of iterators are controled by the iterator itself, instead of the client
        
            are less flexibles because the client doesn't have any kind of control over the iteration process
        */
        for (int i = 0; i < children.size()-1; i++) {
            System.out.print("item=");
            
            // because it is the iterator that is stepping through the elements, you have to tell the iterator what to do with those elements as it goes through
            children.get(i).print();
            
            System.out.print(", ");
        }
        System.out.print("item=");
        children.get(children.size()-1).print();
        
        System.out.print("}}");
    }

    // "composite" methods
    @Override
    public MenuComponent getChild(int i) {
        return children.get(i);
    }

    // using the component interface you can manage both kind of objects in the same way
    @Override
    public void remove(MenuComponent component) {
        children.remove(component);
    }

    @Override
    public void add(MenuComponent component) {
        children.add(component);
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        // creates an Iterator with its children for this composite (only one per composite object)
        if (iterator == null) {
            iterator = new CompositeIterator(children.iterator());
        }
        
        return iterator;
    }
}
