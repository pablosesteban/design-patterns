/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.observer;

import java.util.ArrayList;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

// gets the data from a Weather Station
public class WeatherData implements Subject {
    // not all observers need the whole state...
    private float temperature;
    private float pressure;
    private float humidity;
    
    // each subject can have many observers (one to many)
    private ArrayList<Observer> observers;
    
    public WeatherData() {
        observers = new ArrayList<>();
    }
    
    @Override
    public void register(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void remove(Observer o) {
        if (observers.contains(o)) {
            // be aware of EQUALS method in observers...
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
    
    // notify the Observers when we get updated measurements from the Weather Station
    public void measurementsChanged() {
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
    
    /*
    in order observers to be able to make PULL requests
    */
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
