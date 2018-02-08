/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design_patterns.structural.proxy.remote.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pablo Santamarta Esteban <pablosesteban@gmail.com>
 */
public interface MyRemoteServer extends Remote {
    String sayHello() throws RemoteException;
}
