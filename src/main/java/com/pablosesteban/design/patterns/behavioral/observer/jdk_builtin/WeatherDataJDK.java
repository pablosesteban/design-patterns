/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.observer.jdk_builtin;

import java.util.Observable;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

// it doesn’t need to keep track of our observers anymore, or manage their registration and removal -> the superclass will handle that
public class WeatherDataJDK extends Observable {
    /*
    holds the data (state)
    
    not all observers need the whole state...
    */
    private float temperature;
    private float pressure;
    private float humidity;
    
    // no longer needs to create a data structure to hold Observers
    public WeatherDataJDK() {}
    
    /*
    notify the Observers when we get updated measurements from the WeatherStation
    
    if notifyObservers() is called without first calling setChanged(), the observers will NOT be notified
    
    is meant to give you more flexibility in how you update observers by allowing you to optimize the notifications
    */
    // 
    public void measurementsChanged() {
        // needed to indicate the state has changed before calling notifyObservers()
        setChanged();
        
        // PULL
        notifyObservers();
    }
    
    /*
    to simulate the change of measurements and test our display elements
    
    TODO: grab measurements off the web
    */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        
        measurementsChanged();
    }
    
    // we are going to use PULL and the Observers will use them to get at the WeatherData object’s state
    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }
    
}
