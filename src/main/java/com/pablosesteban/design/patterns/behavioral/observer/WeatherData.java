/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

// gets the data from a Weather Station
public class WeatherData implements Subject {
    private float temperature;
    private float pressure;
    private float humidity;
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
    
    // to test our display elements. TODO: grab measurements off the web
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        
        measurementsChanged();
    }
    
}
