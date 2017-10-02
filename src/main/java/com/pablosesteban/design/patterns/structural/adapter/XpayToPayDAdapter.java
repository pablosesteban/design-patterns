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
ADAPTER
    adapts the interface of the Adaptee to the Target interface

    calls Adaptee operations that carry out the request
*/
public class XpayToPayDAdapter implements PayD {
    private String custCardNo;
    private String cardOwnerName;
    private String cardExpMonthDate;
    private Integer cVVNo;
    private Double totalAmount;
    
    // object composition (Adaptee)
    private final Xpay xpay;
    
    public XpayToPayDAdapter(Xpay xpay) {
        this.xpay = xpay;
        
        setProperties();
    }
    
    @Override
    public String getCustCardNo() {
        return custCardNo;
    }

    @Override
    public String getCardOwnerName() {
        return cardOwnerName;
    }

    @Override
    public String getCardExpMonthDate() {
        return cardExpMonthDate;
    }

    @Override
    public Integer getCVVNo() {
        return cVVNo;
    }

    @Override
    public Double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public void setCustCardNo(String custCardNo) {
        this.custCardNo = custCardNo;
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    @Override
    public void setCardExpMonthDate(String cardExpMonthDate) {
        this.cardExpMonthDate = cardExpMonthDate;
    }

    @Override
    public void setCVVNo(Integer cVVNo) {
        this.cVVNo = cVVNo;
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    private void setProperties() {
        setCVVNo(xpay.getCardCVVNo().intValue());
        setCardExpMonthDate(xpay.getCardExpMonth() + "-" + xpay.getCardExpYear());
        setCardOwnerName(xpay.getCustomerName());
        setCustCardNo(xpay.getCreditCardNo());
        setTotalAmount(xpay.getAmount());
    }
}
