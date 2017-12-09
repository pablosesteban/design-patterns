/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.facade;

import com.pablosesteban.design.patterns.structural.facade.subsystem.DvdPlayer;
import com.pablosesteban.design.patterns.structural.facade.subsystem.PopcorPopper;
import com.pablosesteban.design.patterns.structural.facade.subsystem.Projector;
import com.pablosesteban.design.patterns.structural.facade.subsystem.Screen;
import com.pablosesteban.design.patterns.structural.facade.subsystem.TheaterLights;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DESIGN PATTERN: FACADE
    provide a unified interface to a set of interfaces in a subsytem and defines a higher-level interface that makes the
    subsystem easier to use

    it allows LOOSE COUPLING between clients and subsystems and also it DECOUPLES them

    it DOESN'T ENCAPSULATE the subsystem classes, i.e. the subsystem classes still remaing available for direct use by clients

    is free to add its own "smarts" in addition to making use of the subsystem

    allows for any number of facades to be created for a given subsystem

    its intent is to provide a simplified interface to a subsystem
*/

/*
DESIGN PRINCIPLE: talk only to your immediate friends (Least Knowledge)
    also called the Law of Demeter
    
    guide us to reduce the interactions between objects to just a few close "friends"

    when you are designing a system, for any object, be careful of the NUMBER of classes it interacts with and also HOW it
    comes to interact with those classes

    prevents us from creating designs that have a large number of classes COUPLED together so that changes in one part of the
    system cascade to other parts

    building a system with a lot of dependencies between many classes make it fragile, costly to maintain and complex to understand

    to follow the principle, for any method in an object invoke only methods that belongs to:
        the object itself

        objects passed in as a parameter to the method

        any object the method instantiates

        any components of the object (instance variables)

    DON'T CALL methods of an object we get back from another method call
        it increases the number of objects the class directly knows

        to avoid it, the principle forces us to ask the object to make the request for us

        station.getThermometer().getTemperature() -> station.getTemperature()

    sometimes there is a drawback as a lot of "wrapper" classes are created to handle method calls to other components,
    increasing the complexity and development time as well as decreasing the runtime performance
*/
public class HomeTheaterFacade {
    // COMPOSITION, in order the facade to have access to the components of the subsystem
    DvdPlayer dvd;
    Projector projector;
    PopcorPopper popcorPopper;
    Screen screen;
    TheaterLights lights;
    
    String movie;

    public HomeTheaterFacade(DvdPlayer dvd, Projector projector, PopcorPopper popcorPopper, Screen screen, TheaterLights lights) {
        this.dvd = dvd;
        this.projector = projector;
        this.popcorPopper = popcorPopper;
        this.screen = screen;
        this.lights = lights;
    }
    
    // bring the components of the subsystem together into a unified interface
    public void watchMovie(String movie) {
        this.movie = movie;
        
        System.out.println("----Watching " + movie + "----");
        
        // DELEGATING the responsibility for each task to the corresponding component in the subsystem
        popcorPopper.on();
        popcorPopper.pop();
        
        lights.dim(40);
        
        screen.down();
        
        projector.on();
        
        dvd.on();
        dvd.play();
    }
    
    public void endMovie() {
        System.out.println("----Ending " + movie + "----");
        
        projector.off();
        
        lights.on();
        
        screen.up();
        
        popcorPopper.off();
        
        dvd.eject();
        dvd.off();
    }
    
    // CLIENT
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(new DvdPlayer(), new Projector(), new PopcorPopper(), new Screen(), new TheaterLights());
        
        homeTheaterFacade.watchMovie("Collateral Beauty");
        
        homeTheaterFacade.endMovie();
    }
}
