/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.behavioral.observer;

import com.pablosesteban.design.patterns.behavioral.observer.displayer.CurrentConditions;
import com.pablosesteban.design.patterns.behavioral.observer.displayer.Forecast;
import com.pablosesteban.design.patterns.behavioral.observer.displayer.Statistics;
import com.pablosesteban.design.patterns.behavioral.observer.jdk_builtin.CurrentConditionsJDK;
import com.pablosesteban.design.patterns.behavioral.observer.jdk_builtin.StatisticsJDK;
import com.pablosesteban.design.patterns.behavioral.observer.jdk_builtin.WeatherDataJDK;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: OBSERVER
    publisher(subject) + subscribers(observers) = obeserver pattern

    defines a one-to-many dependency between objects so that when one object changes state (SUBJECT), all of its dependents are notified and updated automatically (OBSERVERS)

    the subject is the sole owner of that data, the observers are dependent on the subject to update them when the data changes -> leads to a cleaner OO design than allowing many objects to control the same data

    provides an object design where subjects and observers are LOOSELY COUPLED:
        the only thing the Subject knows about an observer is that it implements a certain interface (Observer)

        the only thing the Subject depends on is a list of objects that implement the Observer interface -> we can add/remove/replace any observer at runtime

        there is no need to modify the subject to add new observers -> implement the Observer interface in the new class and register as an observer

        Subjects and Observers can be reused independently of each other

        changes to either Subjects or Observers will not affect each other

    JAVA provides some built-in support for the Observer pattern

DESIGN PRINCIPLE: strive for loosely coupled designs, instead of tightly coupled, between objects that interact
    loosely coupled designs allow us to build flexible OO systems that can handle change because they minimize the interdependency between objects
*/
public class WeatherStation {
    public static void main(String[] args) {
        // Subject - Publisher
        WeatherData weatherData = new WeatherData();
        
        // Observers - Suscribers
        new CurrentConditions(weatherData);
        new Statistics(weatherData);
        new Forecast(weatherData);
        
        // simulate new weather measurements
        weatherData.setMeasurements(27, 30, 30.4f);
        weatherData.setMeasurements(37, 40, 10.4f);
        weatherData.setMeasurements(19, 10, 3.4f);
        
        // Subject - Publisher
        WeatherDataJDK weatherDataJdk = new WeatherDataJDK();
        
        // Observers - Suscribers
        new CurrentConditionsJDK(weatherDataJdk);
        new StatisticsJDK(weatherDataJdk);
        
        // simulate new weather measurements
        weatherDataJdk.setMeasurements(27, 30, 30.4f);
        weatherDataJdk.setMeasurements(37, 40, 10.4f);
        weatherDataJdk.setMeasurements(19, 10, 3.4f);
    }
    
}
