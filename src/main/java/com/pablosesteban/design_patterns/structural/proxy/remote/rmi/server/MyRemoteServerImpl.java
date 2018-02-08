/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.proxy.remote.rmi.server;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public class MyRemoteServerImpl extends UnicastRemoteObject implements MyRemoteServer {
    public MyRemoteServerImpl() throws RemoteException {}
    
    @Override
    public String sayHello() throws RemoteException {
        return "Server says hello";
    }
    
    public static void main(String[] args) {
        try {
            MyRemoteServer service = new MyRemoteServerImpl();
            
            Naming.rebind("RemoteHelloService", service);
            
            System.out.println("Service ready!");
        }catch (IOException ioe) {
            ioe.printStackTrace();
            
            System.exit(1);
        }
    }
}
