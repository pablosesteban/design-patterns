/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.composite;

import java.util.List;

/**
 *
 * @author psantamartae
 */

/*
COMPOSITE CLASS
    containter object contains other objects: containers and primitives (childrens)
    
    defines behavior for components having childrens

    implements behavior for child-related operations in the Component interface
*/

/*
IMPLEMENTATION ISSUE: COMPOSITE CLASS CACHE
    if you need to traverse or search compositions frequently this class can cache information about its children

    cache information that lets it short-circuit the traversal or search

    this works best when there are parent references for components as changes to a component will require invalidating the caches of its parents
*/

/*
IMPLEMENTATION ISSUE: DELETING COMPONENTS
    in languages without Garbage Collection this class should delete its children when its destroyed

    if Leaf classes are immutable those would be the exception
*/
public class Directory extends AbstractFile {
    private List<AbstractFile> files;
    
    public Directory(String name, List<AbstractFile> files) {
        this.name = name;
        this.files = files;
    }
    
    @Override
    public void add(AbstractFile file) {
        file.parent = this;
        
        files.add(file);
    }
    
    @Override
    public void remove(AbstractFile file) {
        files.remove(file);
    }
    
    @Override
    public void ls() {
        System.out.println(App.formatter + name);
        
        for (int i = 0; i < App.FORMAT; i++) {
            App.formatter.append(" ");
        }
        
        for (AbstractFile file : files) {
            file.ls();
        }
        
        App.formatter.setLength(App.formatter.length() - App.FORMAT);
    }
    
}
