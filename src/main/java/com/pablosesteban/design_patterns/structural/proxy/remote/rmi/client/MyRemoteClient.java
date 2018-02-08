/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.proxy.remote.rmi.client;

import com.pablosesteban.design_patterns.structural.proxy.remote.rmi.server.MyRemoteServer;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class MyRemoteClient {
    public void go() {
        try {
            MyRemoteServer service = (MyRemoteServer) Naming.lookup("rmi://127.0.0.1/RemoteHelloService");
            
            System.out.println(service.sayHello());
        }catch(IOException | NotBoundException e) {
            e.printStackTrace();
            
            System.exit(1);
        }
    }
    
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }
}