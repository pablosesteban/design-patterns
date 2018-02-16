/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.pablosesteban.design_patterns.structural.proxy.virtual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class App extends JFrame {
    JMenuBar menuBar;
    JMenu menu;
    
    ImageComponent imageComponent;
    Map<String, String> cds = new HashMap<>();
    URL initialUrl;
    
    public App(String title) {
        super(title);
        
        menu = new JMenu("Favorite CDs");
        
        menuBar = new JMenuBar();
        menuBar.add(menu);
        
        getCdcovers();
        
        try {
            initialUrl = new URL((String)cds.get("Selected Ambient Works, Vol. 2"));
        } catch (MalformedURLException mue) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, mue.getMessage(), mue);
        }
        
        for (Map.Entry<String, String> entry : cds.entrySet()) {
            JMenuItem menuItem = new JMenuItem(entry.getKey());
            
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    imageComponent.setIcon(new ImageProxy(getImageUrl(event.getActionCommand())));
                    
                    repaint();
                }
            });
            
            menu.add(menuItem);
        }
        
        setJMenuBar(menuBar);
        
        Icon icon = new ImageProxy(initialUrl);
        
        imageComponent = new ImageComponent(icon);
        
        getContentPane().add(imageComponent);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
    }
    
    private void getCdcovers() {
        cds.put("Ambient: Music for Airports","http://images.amazon.com/images/P/B000003S2K.01.LZZZZZZZ.jpg");
        cds.put("Buddha Bar","http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
        cds.put("Ima","http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
        cds.put("Karma","http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
        cds.put("MCMXC A.D.","http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
        cds.put("Northern Exposure","http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
        cds.put("Selected Ambient Works, Vol. 2","http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");
        cds.put("Oliver","http://www.cs.yale.edu/homes/freeman-elisabeth/2004/9/Oliver_sm.jpg");
    }
    
    private URL getImageUrl(String name) {
        URL url = null;
        
        try {
            url = new URL(cds.get(name));
        } catch (MalformedURLException mue) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, mue.getMessage(), mue);
        }
        
        return url;
    }
    
    public static void main(String[] args) {
        new App("CD Cover Viewer");
    }
}
