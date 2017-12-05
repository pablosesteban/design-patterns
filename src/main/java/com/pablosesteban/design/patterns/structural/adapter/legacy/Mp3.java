/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.adapter.legacy;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class Mp3 implements OldFormat {
    @Override
    public void playFile() {
        System.out.println("Playing mp3 file");
    }

    @Override
    public String toString() {
        return "Mp3{" + '}';
    }
}
