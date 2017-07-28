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

// COMPONENT
public abstract class AbstractFile {
    void add(AbstractFile file) {
        throw new UnsupportedOperationException("Not supported!");
    }
    
    abstract void ls();
    
}
