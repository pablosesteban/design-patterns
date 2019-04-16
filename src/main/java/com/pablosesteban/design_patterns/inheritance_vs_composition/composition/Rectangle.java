/**
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
package com.pablosesteban.design_patterns.inheritance_vs_composition.composition;

public class Rectangle implements Form {
	private double side;
	private double height;
	
	public Rectangle(double side, double height) {
		this.side = side;
		this.height = height;
	}

	@Override
	public double area() {
		return side * height;
	}
}
