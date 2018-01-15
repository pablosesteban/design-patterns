/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.state.badapproach;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
this approach of implement the state is not very OO:
    isn’t adhering to the Open Closed Principle

    it hasn’t encapsulate anything that varies

this design is not going to be easy to maintain and extend, i.e. further additions are likely to cause bugs in working code
*/
public class GumballMachine {
    // states
    private final static int SOLD_OUT = 0;
    private final static int NO_QUARTER = 1;
    private final static int HAS_QUARTER = 2;
    private final static int SOLD = 3;
    
    // current state
    private int state = SOLD_OUT;
    // number of gumballs
    private int count = 0;
    
    public GumballMachine(int count) {
        this.count = count;
        
        if (count > 0) {
            state = NO_QUARTER;
        }
    }
    
    // actions: manage transitions in a bad way
    public void insertQuarter() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("You can't insert another quarter");
                break;
            case NO_QUARTER:
                state = HAS_QUARTER;
                
                System.out.println("Quarter inserted");
                
                break;
            case SOLD:
                System.out.println("Please wait, we're already giving you a gumball");
                break;
            case SOLD_OUT:
                System.out.println("Machine is sold out");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public void ejectQuarter() {
        switch (state) {
            case HAS_QUARTER:
                state = NO_QUARTER;
                
                System.out.println("Quarter returned");
                
                break;
            case NO_QUARTER:
                System.out.println("You haven’t inserted a quarter");
                break;
            case SOLD:
                System.out.println("Sorry, you already turned the crank");
                break;
            case SOLD_OUT:
                System.out.println("You can’t eject, you haven’t inserted a quarter yet");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public void turnCrank() {
        switch (state) {
            case HAS_QUARTER:
                state = SOLD;
                
                System.out.println("Crank turned");
                
                dispense();
                
                break;
            case NO_QUARTER:
                System.out.println("You turned but there’s no quarter");
                break;
            case SOLD:
                System.out.println("Turning twice doesn’t get you another gumball");
                break;
            case SOLD_OUT:
                System.out.println("You turned, but there are no gumballs");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    private void dispense() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("No gumball dispensed");
                break;
            case NO_QUARTER:
                System.out.println("You need to pay first");
                break;
            case SOLD:
                System.out.println("A gumball comes rolling out the slot");
                
                count--;
                
                if (count == 0) {
                    state = SOLD_OUT;
                }else {
                    state = NO_QUARTER;
                }
                
                break;
            case SOLD_OUT:
                System.out.println("No gumball dispensed");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" + "state=" + state + ", count=" + count + '}';
    }
    
    public static void main(String[] args) {
        GumballMachine gm = new GumballMachine(10);
        System.out.println(gm);
        
        System.out.println("----TEST 1----");
        gm.insertQuarter();
        gm.turnCrank();
        System.out.println(gm);
        
        System.out.println("----TEST 2----");
        gm.insertQuarter();
        gm.ejectQuarter();
        gm.turnCrank();
        System.out.println(gm);
        
        System.out.println("----TEST 3----");
        gm.insertQuarter();
        gm.turnCrank();
        gm.insertQuarter();
        gm.turnCrank();
        gm.ejectQuarter();
        System.out.println(gm);
        
        System.out.println("----TEST 4----");
        gm.insertQuarter();
        gm.insertQuarter();
        gm.turnCrank();
        gm.insertQuarter();
        gm.turnCrank();
        gm.insertQuarter();
        gm.turnCrank();
        System.out.println(gm);
    }
}
