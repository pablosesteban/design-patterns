/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.behavioral.observer.jdk_builtin;

import com.pablosesteban.design_patterns.patterns.behavioral.observer.displayer.*;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class StatisticsJDK implements Observer, Displayer {
    // depends on the Subject to get its state
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float averageSum = 0.0f;
    private int numReadings;
    
    // keep this reference in order to allow the Observer to un-register itself with the Subject
    private Observable weatherData;
    
    public StatisticsJDK(Observable weatherData) {
        this.weatherData = weatherData;
        
        weatherData.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataJDK) {
            WeatherDataJDK wd = (WeatherDataJDK)o;
            
            averageSum += wd.getTemperature();
            
            numReadings++;
            
            if (wd.getTemperature() > maxTemp) {
                maxTemp = wd.getTemperature();
            }
            
            if (wd.getTemperature() < minTemp) {
                minTemp = wd.getTemperature();
            }
            
            display();
        }
    }
    
    @Override
    public void display() {
        System.out.println("StatisticsTemperatureJDK{\n\taverageSum: " + Math.round(averageSum / numReadings) + ",\n\tmaxTemp: " + maxTemp + ",\n\tminTemp: " + minTemp + "\n}");
    }
    
}
