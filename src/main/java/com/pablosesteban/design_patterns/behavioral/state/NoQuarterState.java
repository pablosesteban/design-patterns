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
public class NoQuarterState implements State {
    private GumballMachine gm;
    
    public NoQuarterState(GumballMachine gm) {
        this.gm = gm;
    }
    
    // implementing the behaviors that are appropriate for the state we are in, some of them includes moving the machine to another State
    @Override
    public void insertQuarter() {
        System.out.println("Quarter inserted");
        
        gm.setState(gm.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven’t inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there’s no quarter");
    }

    // this is an inappropriate action for this state
    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }
    
}
