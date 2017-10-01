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
TARGET
    defines the domain-specific interface that Client uses
*/
public interface PayD {
    public String getCustCardNo();
    public void setCustCardNo(String custCardNo);
    
    public String getCardOwnerName();
    public void setCardOwnerName(String cardOwnerName);
    
    public String getCardExpMonthDate();
    public void setCardExpMonthDate(String cardExpMonthDate);
    
    public Integer getCVVNo();
    public void setCVVNo(Integer cVVNo);
    
    public Double getTotalAmount();
    public void setTotalAmount(Double totalAmount);
}
