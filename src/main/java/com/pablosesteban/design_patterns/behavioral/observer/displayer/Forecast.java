/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.observer.displayer;

import com.pablosesteban.design_patterns.behavioral.observer.Observer;
import com.pablosesteban.design_patterns.behavioral.observer.WeatherData;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class Forecast implements Observer, Displayer {
    // depends on the Subject to get its state
    private float currentPressure = 29.92f;
    private float lastPressure;
    
    // keep this reference in order to allow the Observer to un-register itself with the Subject
    private WeatherData weatherData;
    
    public Forecast(WeatherData weatherData) {
        this.weatherData = weatherData;
        
        weatherData.register(this);
    }
    
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        
        currentPressure = pressure;
        
        display();
    }
    
    public void display() {
        System.out.print("Forecast: ");
        
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        }else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        }else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
    
}
