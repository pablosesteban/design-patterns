/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.adapter.legacy;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
ADAPTEE INTERFACE
    the interface which is going to be adapted

    all requests get delegated to it at the end
*/
public interface OldFormat {
    void playFile();
}
