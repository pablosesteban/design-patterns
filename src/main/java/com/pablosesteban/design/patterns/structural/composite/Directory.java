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
COMPOSITE
    defines behavior for components having childrens

    implements behavior for child-related operations in the Component interface
*/
public class Directory extends AbstractFile {
    private String name;
    private List<AbstractFile> files;
    
    public Directory(String name, List<AbstractFile> files) {
        this.name = name;
        this.files = files;
    }
    
    @Override
    public void add(AbstractFile file) {
        files.add(file);
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
