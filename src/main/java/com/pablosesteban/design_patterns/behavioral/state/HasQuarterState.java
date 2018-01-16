/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.state;

import java.util.Random;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class HasQuarterState implements State {
    // random number generator to generate the 10% change of winning
    private Random random = new Random(System.currentTimeMillis());
    private GumballMachine gm;
    
    public HasQuarterState(GumballMachine gm) {
        this.gm = gm;
    }
    
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        
        gm.setState(gm.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned");
        
        int winner = random.nextInt(10);
        
        if (winner == 0 && gm.getCount() > 1) {
            gm.setState(gm.getWinnerState());
        }else {
            gm.setState(gm.getSoldState());
        }
    }
    
    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public String toString() {
        return "HasQuarterState{" + '}';
    }
    
}
