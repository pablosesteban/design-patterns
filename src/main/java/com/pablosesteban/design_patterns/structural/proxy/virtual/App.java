/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.proxy.virtual;

import java.awt.Color;
import java.awt.FlowLayout;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class App {
    public static void main(String[] args) throws MalformedURLException {
        ImageProxy imageProxy = new ImageProxy(new URL("file://C:\\Users\\psantamartae\\Documents\\jjf-wallpaper_1600.jpg"));
        
        JFrame frame = new JFrame("Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(imageProxy.getImageIcon().getImage());
        frame.setVisible(true);
    }
}
