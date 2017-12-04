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
CLIENT
    
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
//        mediaPlayer.addFormat(mp3);
//        mediaPlayer.addFormat(avi);
        
        OldFormatAdapter mp3Adapter = new OldFormatAdapter(mp3);
        OldFormatAdapter aviAdapter = new OldFormatAdapter(avi);
        
        mediaPlayer.addFormat(mp3Adapter);
        mediaPlayer.addFormat(aviAdapter);
        
        System.out.println(mediaPlayer);
    }
}
