/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablosesteban.design.patterns.structural.adapter;

/**
 *
 * @author psantamartae
 */

/*
ADAPTER DESIGN PATTERN
    convert the interface of a class into another interface clients expect and lets classes work together that couldn't otherwise because of incompatible interfaces
    
    two ways:
        INHERITANCE: making "adapter" class inherit from both "adaptee" and "targer" interfaces (multiple inheritance required)
        
        COMPOSITION: composing the "adaptee" instance within the "adapter" instance and implementing it in terms of the "adaptee" interface
*/
public class App {
    public static void main(String[] args) {
        // Object for Xpay
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Max Warner");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short)235);
        xpay.setAmount(2565.23);

        PayD payD = new XpayToPayDAdapter(xpay);
        testPayD(payD);
    }
    
    private static void testPayD(PayD payD){
        System.out.println("Owner: " + payD.getCardOwnerName());
        System.out.println("Card No.: " + payD.getCustCardNo());
        System.out.println("Exp. date: " + payD.getCardExpMonthDate());
        System.out.println("CVV: " + payD.getCVVNo());
        System.out.println("Amount: " + payD.getTotalAmount());
    }
}
