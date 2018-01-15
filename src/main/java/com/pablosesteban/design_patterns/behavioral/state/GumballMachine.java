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

/*
CLIENT
    
*/
public class GumballMachine {
    // states: instead of using ints, use State objects
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State winnerState;
    
    private State state = soldOutState;
    private int count = 0;
    
    public GumballMachine(int count) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState();
        
        this.count = count;
        
        if (count > 0) {
            state = noQuarterState;
        }
    }
    
    // actions: DELEGATE to the current State object
    public void insertQuarter() {
        state.insertQuarter();
    }
    
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    
    public void turnCrank() {
        state.turnCrank();
        
        // we don't need a dispense method in this class as it is an internal action which cannot be called from here directly but from the state object
        if (state instanceof SoldState) { // in order not to dispense if the state is incorrect (because the turnCrank failed)
            state.dispense();
        }
    }
    
    // helper method
    void releaseGumball() {
        System.out.println("A gumball comes rolling out the slot");
        
        if (count != 0) {
            count--;
        }
    }
    
    // allows State objects to transition this class to a different state
    public void setState(State state) {
        this.state = state;
    }
    
    public State getHasQuarterState() {
        return hasQuarterState;
    }
    
    public State getNoQuarterState() {
        return noQuarterState;
    }
    
    public State getSoldState() {
        return soldState;
    }
    
    public State getSoldOutState() {
        return soldOutState;
    }
    
    public State getWinnerState() {
        return winnerState;
    }
    
    public int getCount() {
        return count;
    }
}
