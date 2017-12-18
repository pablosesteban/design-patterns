/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.behavioral.strategy.behavior.fly;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
set of classes related to fly behavior

with this design:
    other kinds of objects can REUSE our fly (and quack) behaviors

    we can add new behaviors (or modify) without modifying anything else

    so we get the benefit of REUSE without the baggage that comes along with inheritance
*/
public interface FlyBehavior {
    void fly();
}
