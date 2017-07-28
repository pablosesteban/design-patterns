/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author psantamartae
 */

/*
CLIENT
    manipulates objects in the composition through the Component interface
*/
public class App {
    public static final int FORMAT = 3;
    public static StringBuffer formatter = new StringBuffer();
    
    public static void main(String[] args) {
        Directory music = new Directory("music", new ArrayList<AbstractFile>());
        
        Directory sabina = new Directory("sabina", new ArrayList<AbstractFile>());
        
        Directory loNiegoTodo = new Directory("lo niego todo", new LinkedList<AbstractFile>());
        Directory alivioDeLuto = new Directory("alivio de luto", new LinkedList<AbstractFile>());
        
        music.add(sabina);
        
        sabina.add(loNiegoTodo);
        sabina.add(alivioDeLuto);
        
        loNiegoTodo.add(new File("quien mas, quien menos.mp3"));
        loNiegoTodo.add(new File("no tan deprisa.mp3"));
        loNiegoTodo.add(new File("lo niego todo.mp3"));
        
        alivioDeLuto.add(new File("pajaros de portugal.mp3"));
        alivioDeLuto.add(new File("pie de guerra.mp3"));
        alivioDeLuto.add(new File("resumiendo.mp3"));
        
        music.ls();
    }
}
