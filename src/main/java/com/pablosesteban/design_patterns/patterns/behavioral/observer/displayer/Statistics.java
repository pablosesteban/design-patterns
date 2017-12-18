/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.behavioral.observer.displayer;

import com.pablosesteban.design_patterns.patterns.behavioral.observer.Observer;
import com.pablosesteban.design_patterns.patterns.behavioral.observer.WeatherData;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class Statistics implements Observer, Displayer {
    // depends on the Subject to get its state
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float averageSum = 0.0f;
    private int numReadings;
    
    // keep this reference in order to allow the Observer to un-register itself with the Subject
    private WeatherData weatherData;
    
    public Statistics(WeatherData weatherData) {
        this.weatherData = weatherData;
        
        weatherData.register(this);
    }
    
    @Override
    public void update(float temp, float humidity, float pressure) {
        averageSum += temp;
        
        numReadings++;
        
        if (temp > maxTemp) {
            maxTemp = temp;
        }
        
        if (temp < minTemp) {
            minTemp = temp;
        }
        
        display();
    }
    
    @Override
    public void display() {
        System.out.println("StatisticsTemperature{\n\taverageSum: " + Math.round(averageSum / numReadings) + ",\n\tmaxTemp: " + maxTemp + ",\n\tminTemp: " + minTemp + "\n}");
    }
    
}
