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
COMPONENT
    declares the interface for objects in the composition
    
    implements default behavior for the interface common to all clases (abstract class)

    declares an interface for accessing and managing its child components and optional for accessing a component's parent (interface)
*/
public abstract class AbstractFile {
    void add(AbstractFile file) {
        throw new UnsupportedOperationException("Not supported!");
    }
    
    abstract void ls();
    
}
