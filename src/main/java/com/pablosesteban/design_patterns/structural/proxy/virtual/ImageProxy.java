/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.proxy.virtual;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class ImageProxy implements Icon {
    // this is the REAL SUBJECT, ImageIcon implements the SUBJECT Icon interface
    private ImageIcon imageIcon;
    
    private URL imageUrl;
    private Thread retrieveImageThread;
    private boolean isRetrievingImage;

    public ImageProxy(URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        }else {
            g.drawString("Loading CD cover, please wait...", x+300, y+190);
            
            if (!isRetrievingImage) {
                isRetrievingImage = true;
                
                retrieveImageThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ie) {
                            Logger.getLogger(ImageProxy.class.getName()).log(Level.SEVERE, ie.getMessage(), ie);
                        }
                        
                        // instantiating the object which is expensive to create
                        imageIcon = new ImageIcon(imageUrl);
                        
                        c.repaint();
                    }
                });
                
                retrieveImageThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        int width = 800;
        
        if (imageIcon != null) {
            width = imageIcon.getIconWidth();
        }
        
        return width;
    }

    @Override
    public int getIconHeight() {
        int height = 600;
        
        if (imageIcon != null) {
            height = imageIcon.getIconHeight();
        }
        
        return height;
    }
}
