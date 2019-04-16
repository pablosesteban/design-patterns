/**
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
package com.pablosesteban.design_patterns.inheritance_vs_composition.inheritance;

import com.pablosesteban.design_patterns.inheritance_vs_composition.composition.Form;

public abstract class Rectangle implements Form {
	private double side;
	private double height;
	
	public Rectangle(double side, double height) {
		this.side = side;
		this.height = height;
	}
	
	public double area() {
		return side * height;
	}
}
