package org.example.Interface_Payment_System;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod {
    BigDecimal balance;
    @Override
    public PaymentResult pay(BigDecimal amount) {

        if(amount.compareTo(new BigDecimal(String.valueOf(balance)))>=0){
            return new PaymentResult(false,"A01-001","Failed to make a Payment");
        }
        return new PaymentResult(true,"A01-001"," You are Successfull");
    }

    @Override
    public String getDisplayName() {
        return "Card Payment ";
    }
}
