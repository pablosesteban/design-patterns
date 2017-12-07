/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.adapter;

import com.pablosesteban.design.patterns.structural.adapter.legacy.Mp3;
import com.pablosesteban.design.patterns.structural.adapter.legacy.Avi;
import java.util.ArrayList;
import java.util.List;
import com.pablosesteban.design.patterns.structural.adapter.legacy.OldFormat;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: ADAPTER
    converts the interface of a class into another interface the clients expect

    lets classes work together that couldn’t otherwise because of incompatible interfaces

    DECOUPLES the client from the implemented interface, and if we expect the interface to change over time, the
    adapter encapsulates that change so that the client doesn’t have to be modified each time it needs to operate
    against a different interface

    OBJECT ADAPTER
        uses composition to wrap the adaptee

        has the added advantage that we can use an adapter with any subclass of the adaptee

        binds the client to an interface, not an implementation (target interface)

    CLASS ADAPTER
        instead of using composition to adapt the Adaptee, the Adapter now subclasses the Adaptee and the Target classes

        needs multiple inheritance to implement it, which isn’t possible in Java

    TWO WAY ADAPTER
        supports both interfaces
        
        just implement both interfaces involved, so the adapter can act in both ways
*/

/*
CLIENT
    is implemented against the target interface

    makes a request to the adapter using the target interface and receives the results without knowing there is an adapter doing the translation
*/
public class MediaPlayer {
    private List<NewFormat> supportedFormats = new ArrayList<>();
    
    public void addFormat(NewFormat format) {
        if (!supportedFormats.contains(format)) {
            supportedFormats.add(format);
        }
    }
    
    public void removeFormat(NewFormat format) {
        if (supportedFormats.contains(format)) {
            supportedFormats.remove(format);
        }
    }
    
    public void playAll() {
        for (NewFormat supportedFormat : supportedFormats) {
            supportedFormat.play();
        }
    }

    @Override
    public String toString() {
        return "MediaPlayer{" + "supportedFormats=" + supportedFormats + '}';
    }
    
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        
        NewFormat mp4 = new Mp4();
        OldFormat mp3 = new Mp3();
        OldFormat avi = new Avi();
        
        mediaPlayer.addFormat(mp4);
        
        // different interface, cannot use those two
        //mediaPlayer.addFormat(mp3);
        //mediaPlayer.addFormat(avi);
        
        // using the adapter
        OldFormatAdapter mp3Adapter = new OldFormatAdapter(mp3);
        OldFormatAdapter aviAdapter = new OldFormatAdapter(avi);
        
        mediaPlayer.addFormat(mp3Adapter);
        mediaPlayer.addFormat(aviAdapter);
        
        mediaPlayer.playAll();
        
        System.out.println(mediaPlayer);
    }
}
