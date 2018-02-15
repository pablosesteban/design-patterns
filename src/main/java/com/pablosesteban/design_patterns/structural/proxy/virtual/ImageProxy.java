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
    // the object which is expensive to create
    private ImageIcon imageIcon;
    private URL imageUrl;
    private Thread retrievingImageThread;
    private boolean retrieving;

    public ImageProxy(URL imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    @Override
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        }else { // construct the expensive object in a different thread
            g.drawString("Loading image, please wait...", x + 300, y + 190);
            
            if (!retrieving) {
                retrieving = true;
                
                retrievingImageThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        imageIcon = new ImageIcon(imageUrl);
                        
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ie) {
                            Logger.getLogger(ImageProxy.class.getName()).log(Level.SEVERE, null, ie);
                        }
                        
                        c.repaint();
                    }
                });
                
                retrievingImageThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        }
        
        return 800;
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null)  {
            return imageIcon.getIconHeight();
        }
        
        return 600;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon image) {
        this.imageIcon = image;
    }
}
