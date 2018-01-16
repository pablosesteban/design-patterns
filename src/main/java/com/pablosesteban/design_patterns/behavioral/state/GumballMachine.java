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
DESIGN PATTERN: STATE
    allows an object to alter its behavior when its internal state changes and the object will appear to change its class

    encapsulates state into separate classes and delgates to the object representing the current state allowing the behavior changing
    along with the internal state

    from the perspective of the client if an object you're using can completely change its behavior, it appears that the object
    is actually instantiated from another class (what changes is the instance of the current state allowing different behavior)

    state transitions can be in
        the State classes, when they are more dynamic (disadvantage of creating dependencies between the state classes)

        the Context class, when they are fixed
    this decision affects to which classes follow the Open Closed Principle, the Context or the State classes
*/

/*
CONTEXT CLASS
    the class that can have any number of internal states

    whenever a request is made on this class it is delegated to the current state to handle it

    the states are used by this to represent its internal state and behavior, so ALL request to the states come from the Context (never from the client directly)
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
        winnerState = new WinnerState(this);
        
        this.count = count;
        
        if (count > 0) {
            state = noQuarterState;
        }
    }
    
    // actions: DELEGATE to the current State object (removing all the if statements difficult to maintain)
    public void insertQuarter() {
        state.insertQuarter();
    }
    
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    
    public void turnCrank() {
        state.turnCrank();
        
        // we don't need a dispense method in this class as it is an internal action which cannot be called from here directly but from the state object
        if (state instanceof SoldState || state instanceof WinnerState) { // in order not to dispense if the state is incorrect (because the turnCrank failed)
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
    
    // as state transitions are inside the state classes this getters methods are meant to reduce the dependencies between states classes
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
