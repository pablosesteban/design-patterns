/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.observer.jdk_builtin;

import com.pablosesteban.design.patterns.behavioral.observer.displayer.*;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class CurrentConditionsJDK implements Observer, Displayer {
    // depends on the Subject to get its state
    private float temperature;
    private float humidity;
    
    // keep this reference in order to allow the Observer to un-register itself with the Subject
    private Observable weatherData;

    // now takes an Observable
    public CurrentConditionsJDK(Observable weatherData) {
        this.weatherData = weatherData;
        
        weatherData.addObserver(this);
    }
    
    /*
    ARGUMENTS:
        Observable o: the Subject that sent the notification
        
        Object arg:
            the data object that was passed to notifyObservers(Object arg) and gets passed to each Observer when it is notified (PUSH)
            
            null if a data object wasn’t specified by notifyObservers() (PULL)
    */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataJDK) {
            WeatherDataJDK wd = (WeatherDataJDK)o;
            
            // PULL only the necessary state
            temperature = wd.getTemperature();
            humidity = wd.getHumidity();
            
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionsJDK{\n\ttemperature: " + temperature + ",\n\thumidity: " + humidity + "\n}");
    }
    
}
