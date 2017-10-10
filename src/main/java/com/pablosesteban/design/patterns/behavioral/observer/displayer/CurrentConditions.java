/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.observer.displayer;

import com.pablosesteban.design.patterns.behavioral.observer.Observer;
import com.pablosesteban.design.patterns.behavioral.observer.Subject;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class CurrentConditions implements Observer, Displayer {
    private float temperature;
    private float humidity;
    
    // keep this reference in order to allow the Observer to un-register itself with the Subject
    private Subject weatherData;

    public CurrentConditions(Subject weatherData) {
        this.weatherData = weatherData;
        
        // register itself with the Subject
        weatherData.register(this);
    }
    
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentConditions{\n\ttemperature: " + temperature + ",\n\thumidity: " + humidity + "\n}");
    }
    
}
