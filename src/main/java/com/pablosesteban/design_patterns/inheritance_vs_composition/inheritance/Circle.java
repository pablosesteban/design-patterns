/**
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
package com.pablosesteban.design_patterns.inheritance_vs_composition.inheritance;

import com.pablosesteban.design_patterns.inheritance_vs_composition.composition.Form;

public abstract class Circle implements Form {
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}
}
