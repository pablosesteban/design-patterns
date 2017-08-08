/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.creational.singleton;

/**
 *
 * @author psantamartae
 */
public class SingletonImpl1 extends SingletonRegistry {
    private SingletonImpl1() {
        register(this.getClass().getName(), this);
    }
}
