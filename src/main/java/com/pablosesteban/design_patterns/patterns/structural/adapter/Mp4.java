/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.structural.adapter;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class Mp4 implements NewFormat {
    @Override
    public void play() {
        System.out.println("Playing mp4 file");
    }

    @Override
    public String toString() {
        return "Mp4{" + '}';
    }
    
}
