/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.observer;

import com.pablosesteban.design.patterns.behavioral.observer.displayers.CurrentConditions;
import com.pablosesteban.design.patterns.behavioral.observer.displayers.StatisticsTemperature;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        new CurrentConditions(weatherData);
        new StatisticsTemperature(weatherData);
        
        // simulate new weather measurements
        weatherData.setMeasurements(27, 30, 30.4f);
        weatherData.setMeasurements(37, 40, 10.4f);
        weatherData.setMeasurements(19, 10, 3.4f);
    }
    
}
