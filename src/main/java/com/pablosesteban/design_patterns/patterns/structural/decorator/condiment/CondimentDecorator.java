/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.patterns.structural.decorator.condiment;

import com.pablosesteban.design_patterns.patterns.structural.decorator.beverage.Beverage;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */

/*
DECORATOR INTERFACE
    decorators need the same “interface” (supertype) as the components they wrap because they need to stand in place of the component

    using inheritance to achieve the type matching not to get behavior

    getting behavior by composing decorators together

    decorator adds its own behavior either before and/or after delegating to the object it decorates to do the rest of the job

    objects can be decorated at any time, so we can decorate objects dynamically at runtime with as many decorators as we like
*/
public abstract class CondimentDecorator extends Beverage {
    /*
    COMPOSITION
        instance variable to hold the beverage which concrete decorators are wrapping (decorating)
    
        each decorator has (wraps) a component
    */
    protected Beverage beverage;
    
    // to require that the concrete decorators all re-implement the getDescription() method
    @Override
    public abstract String getDescription();
    
}
