/**
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
package com.pablosesteban.design_patterns.inheritance_vs_composition.inheritance;

import com.pablosesteban.design_patterns.inheritance_vs_composition.composition.Rectangle;

/*
 * CLASS INHERITANCE is one of the two techniques for reusing functionality in object-oriented systems, which lets
 * you define an object's implementation (subclass) in terms of another object's implementation (parent class).
 * Reuse by subclassing is often referred to as white-box reuse. It refers to visibility as the internals of parent
 * classes are often visible to subclasses.
 * Advantages:
 * 	- it is defined statically at compile-time and is straightforward to use, since it's supported directly by the
 * 	  programming language.
 * 	- makes it easier to modify the implementation being reused, i.e. when a subclass overrides some but not all
 * 	  operations, it can affect the operations it inherits as well.
 * Disadvantages:
 * 	- you can't change the implementations inherited from parent classes at run-time, because inheritance is defined
 * 	  at compile-time.
 * 	- parent classes often define at least part of their subclasses' physical representation. Because inheritance
 * 	  exposes a subclass to details of its parent's implementation, it's often said that "inheritance breaks
 * 	  encapsulation".
 * 	- the implementation of a subclass becomes so bound up with the implementation of its parent class that any change
 * 	  in the parent's implementation will force the subclass to change. Implementation dependencies can cause problems
 * 	  when you're trying to reuse a subclass. Could any aspect of the inherited implementation not be appropriate for
 * 	  new problem domains, the parent class must be rewritten or replaced by something more appropriate. This dependency
 * 	  limits flexibility and ultimately reusability. One cure for this is to inherit only from abstract classes, since
 * 	  they usually provide little or no implementation.
 */
public class RectangleWindow extends Rectangle {
	public RectangleWindow(double side, double height) {
		super(side, height);
	}
	
	public static void main(String[] args) {
		RectangleWindow rectangleWindow = new RectangleWindow(5, 10);
		System.out.println("5 by 10 rectangular window's area: " + rectangleWindow.area());
	}
}
