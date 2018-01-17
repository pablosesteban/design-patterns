/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.state;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class SoldOutState implements State {
    private GumballMachine gm;
    
    public SoldOutState(GumballMachine gm) {
        this.gm = gm;
    }
    
    // we can't do anything until someone refills the machine
    @Override
    public void insertQuarter() {
        System.out.println("Machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can’t eject, you haven’t inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
    
    @Override
    public String toString() {
        return "SoldOutState{" + '}';
    }
    
}
