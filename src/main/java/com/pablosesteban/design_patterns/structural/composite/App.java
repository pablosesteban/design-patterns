/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.composite;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author psantamartae
 * 
 * COMPOSITE DESIGN PATTERN
 *      compose objects into tree structures to represent part-whole hierarchies
 *      
 *      lets clients treat individual objects and compositions of objects uniformly
 * 
 *      code that uses these classes must treat primitive and container objects differently even if most of the time the user treats them identically
 * 
 *      makes the client simple
 * 
 *      makes it easier to add new kinds of components
 * 
 *      a disadvantage is that can make the design overly general:
 *          makes it harder to restrict the components of a composite
 * 
 *          you can't rely on type system to have only certain components on the composite (use runtime checks)
 */

/*
CLIENT CLASS
    use the Component interface to interact with objects in the composite structure and if:
        the component is a Leaf, the request is handled directly

        the component is a Composite, forwards the request to its child components and usually performs operations before and/or after forwarding
*/
public class App {
    public static final int FORMAT = 3;
    public static StringBuffer formatter = new StringBuffer();
    
    public static void main(String[] args) {
        Directory music = new Directory("MUSIC", new ArrayList<AbstractFile>());
        
        Directory sabina = new Directory("JOAQUIN SABINA", new ArrayList<AbstractFile>());
        
        Directory loNiegoTodo = new Directory("LO NIEGO TODO (2017)", new LinkedList<AbstractFile>());
        Directory alivioDeLuto = new Directory("ALIVIO DE LUTO (2005)", new LinkedList<AbstractFile>());
        
        music.add(sabina);
        
        sabina.add(loNiegoTodo);
        sabina.add(alivioDeLuto);
        
        File track1 = new File("Quien mas, quien menos.mp3");
        File track2 = new File("No tan deprisa.mp3");
        File track3 = new File("Lo niego todo.mp3");
        
        loNiegoTodo.add(track1);
        loNiegoTodo.add(track2);
        loNiegoTodo.add(track3);
        
        File track4 = new File("Pajaros de portugal.mp3");
        File track5 = new File("Pie de guerra.mp3");
        File track6 = new File("Resumiendo.mp3");
        
        alivioDeLuto.add(track4);
        alivioDeLuto.add(track5);
        alivioDeLuto.add(track6);
        
        music.ls();
        
        System.out.println(music);
        System.out.println(sabina);
        System.out.println(loNiegoTodo);
        System.out.println(alivioDeLuto);
        
        alivioDeLuto.remove(track6);
        
        music.ls();
    }
    
}
