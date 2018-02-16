/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.proxy;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
SUBJECT INTERFACE
    both the Proxy and the Real Subject implement the Subject interface

    this allows any client to treat the proxy just like the real rubject
*/
public interface WizardTower {
    void enter(Wizard w);
}
