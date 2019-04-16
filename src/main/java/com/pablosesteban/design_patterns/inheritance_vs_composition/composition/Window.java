/**
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
package com.pablosesteban.design_patterns.inheritance_vs_composition.composition;

/*
 * OBJECT COMPOSITION is an alternative technique to class inheritance for reusing functionality in object-oriented
 * systems, here new functionality is obtained by assembling or composing objects to get more complex functionality.
 * It requires that the objects being composed have well-defined interfaces.
 * This style of reuse is called black-box reuse, because no internal details of objects being composed are visible.
 * Advantages:
 * 	- is defined dynamically at run-time through objects acquiring references to other objects. Requires objects to
 * 	  respect each others' interfaces that don't stop you from using one object with many others.
 *  - doesn't break encapsulation because objects are accessed solely through their interfaces.
 *  - there are substantially fewer implementation dependencies because an object's implementation will be written in
 *    terms of object interfaces, so any object can be replaced at run-time by another as long as it has the same type.
 *  - helps to keep each class encapsulated and focused on one task. Classes and class hierarchies will remain small
 *    and will be less likely to grow into unmanageable monsters.
 *  - designs will have more objects, if fewer classes, and the system's behavior will depend on their interrelationships
 *    instead of being defined in one class.
 * Ideally, you shouldn't have to create new components to achieve reuse. You should be able to get all the functionality
 * you need just by assembling existing components through object composition. But this is rarely the case, because the
 * set of available components is never quite rich enough in practice. Reuse by inheritance makes it easier to make new
 * components that can be composed with old ones, so inheritance and object composition thus work together.
 * The experience is that designers overuse inheritance as a reuse technique, and designs are often made more reusable
 * and simpler by depending more on object composition.
 * 
 * DELEGATION is a way of making object composition as powerful for reuse as inheritance.
 * Two objects are involved in handling a request: a receiving object delegates operations to its delegate. This is analogous
 * to subclasses deferring requests to parent classes.
 * With inheritance, an inherited operation can always refer to the receiving object through the "this" keyword. To achieve
 * the same effect with delegation, the receiver passes itself to the delegate to let the delegated operation refer to the receiver.
 * Main advantage:
 * 	- makes it easy to compose behaviors at run-time and to change the way they're composed.
 * Disadvantages:
 * 	- one tradeoff which shares with other techniques that make software more flexible through object composition, is that dynamic,
 *    highly parameterized software is harder to understand than more static software.
 * 	- there are also run-time inefficiencies, but the human inefficiencies are more important in the long run.
 * Delegation is an extreme example of object composition and it shows that you can always replace inheritance with object composition
 * as a mechanism for code reuse.
 */
public class Window {
	private Form form;
	
	public Window(Form form) {
		this.form = form;
	}
	
	public double area() {
		return form.area();
	}
	
	public static void main(String[] args) {
		Window rectangleWindow = new Window(new Rectangle(5, 10));
		System.out.println("5 by 10 rectangular window's area: " + rectangleWindow.area());
		
		Window circleWindow = new Window(new Circle(5));
		System.out.println("5 radius cirular window's area: " + circleWindow.area());
	}
}
