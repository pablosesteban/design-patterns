/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.composite;

/**
 *
 * @author psantamartae
 */

/*
COMPONENT CLASS
    declares the interface for objects in the composition
    
    implements default behavior for the interface common to all clases (abstract class)

    declares an interface for accessing and managing its child components and optional for accessing a component's parent (interface)
*/

/*
IMPLEMENTATION ISSUE: SHARING COMPONENTS
    for reduce storage requirements
    
    but when a component can have no more than one parent, it becomes difficult
    
    2 possible solutions:
        store multiple parents (can lead to ambiguities)
            
        use the Flyweight Design Pattern
*/

/*
IMPLEMENTATION ISSUE: LIST OF COMPONENTS IN COMPONENT CLASS
    defining a set of children as an instance variable in the Component class incurs in a space penalty

    is worthwhile only if there are a few children in the structure
*/

/*
IMPLEMENTATION ISSUE: CHILD ORDERING
    many design specify an ordering on the children

    must design child access and managing interface carefully to manage the sequence of children (Iterator Design Pattern)
*/
public abstract class AbstractFile {
    String name;
    
    /*
    IMPLEMENTATION ISSUE: EXPLICIT PARENT REFERENCES
        can simplify the traversal (moving up) and management (deleting) of a composite structure
    
        help support the Chain of Responsibility Design Pattern
    
        the usual place to define the parent is in the Component class
    
        INVARIANT: all children of a composite have as their parent the composite that in turn has them as children
            to ensure this, change a component's parent only when it's being added or removed from a composite
    */
    AbstractFile parent;
    
    /*
    IMPLEMENTATION ISSUE: MAXIMIZING THE COMPONENT INTERFACE
        in order to make clients unaware of the specific Leaf or Composite classes they are using
        
        to do that, define as many common ops in the Component class as possible
        
        this goal can conflict with the principle of class hierarchy design: a class should only define ops that are meaningful ot ist subclasses
            there are some ops that don't seem to make sense for Leaf classes (add and remove)
    */
    /*
    IMPLEMENTATION ISSUE: DECLARING THE CHILD MANAGEMENT OPS (ADD/REMOVE)
        in Component class
            gives you TRANSPARENCY and you can treat all components uniformly
            
            but clients may try to do meaningless things like add/remove from Leaf classes
    
            2 possible ways
                make add and remove fail by default throwing an exception
    
                change the meaning of remove: if component maintains a parent ref you can remove itself from its parent
    
        in Composite class
            gives you SAFETY because all attemps to add/remove from Leaf classes will be caught at compile-time in a statically typed language
    
            but lose transparency as Leaf and Composite classes have different interfaces
    */
    void add(AbstractFile file) {
        throw new UnsupportedOperationException("Not supported!");
    }
    
    void remove(AbstractFile file) {
        throw new UnsupportedOperationException("Not supported!");
    }
    
    abstract void ls();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (obj instanceof AbstractFile) {
            if (((AbstractFile) obj).name.equals(name)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public String toString() {
        return "{name: " + name + ", parent: " + (parent != null ? parent.name : "null") + "}";
    }
    
}
