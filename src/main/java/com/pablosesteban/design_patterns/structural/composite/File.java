/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.composite;

/**
 *
 * @author psantamartae
 */

/*
LEAF CLASS
    leaf objects has no childrens

    defines behavior for primitive objects in the composition
*/
public class File extends AbstractFile {
    public File(String name) {
        this.name = name;
    }
    
    @Override
    public void ls() {
        System.out.println(App.formatter + name);
    }
    
}
