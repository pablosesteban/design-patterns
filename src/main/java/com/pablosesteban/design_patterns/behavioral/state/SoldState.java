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
public class SoldState implements State {
    private GumballMachine gm;
    
    public SoldState(GumballMachine gm) {
        this.gm = gm;
    }
    
    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn’t get you another gumball");
    }

    // in this state the customer paid
    @Override
    public void dispense() {
        gm.releaseGumball();
        
        if (gm.getCount() > 0) {
            gm.setState(gm.getNoQuarterState());
        }else {
            System.out.println("Machine is sold out");
            
            gm.setState(gm.getSoldOutState());
        }
    }

    @Override
    public String toString() {
        return "SoldState{" + '}';
    }
    
}
