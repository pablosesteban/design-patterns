/**
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
package com.pablosesteban.design_patterns.inheritance_vs_composition.inheritance;

import com.pablosesteban.design_patterns.inheritance_vs_composition.composition.Circle;

public class CircleWindow extends Circle {
	public CircleWindow(double radius) {
		super(radius);
	}
	
	public static void main(String[] args) {
		CircleWindow circleWindow = new CircleWindow(5);
		System.out.println("5 radius cirular window's area: " + circleWindow.area());
	}
}
