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
ADAPTEE
    defines an existing interface that needs adapting
*/
public interface Xpay {
    String getCreditCardNo();
    void setCreditCardNo(String creditCardNo);
    
    String getCustomerName();
    void setCustomerName(String customerName);
    
    String getCardExpMonth();
    void setCardExpMonth(String cardExpMonth);
    
    String getCardExpYear();
    void setCardExpYear(String cardExpYear);
    
    Short getCardCVVNo();
    void setCardCVVNo(Short cardCVVNo);
    
    Double getAmount();
    void setAmount(Double amount);
}
