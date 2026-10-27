package org.example.Interface_Payment_System;

import java.math.BigDecimal;

public class VoucherPayment implements PaymentMethod    {
    BigDecimal balance;
    PaymentResult paymentResult;
    @Override
    public PaymentResult pay(BigDecimal amount) {
        if(amount.compareTo(new BigDecimal(String.valueOf(balance)))>=0){
            return new PaymentResult(true,"AO2-002"," You have failed to make the EFT");

        }
        balance = balance.subtract(amount);
        System.out.println("Vouchar R:" +paymentResult.successful() );
        System.out.println("References:" + paymentResult.reference());
        System.out.println("Message: " + paymentResult.message());

        return new PaymentResult(true,"A02-002"," You have successfully make the IntantEfPayment");

    }


    @Override
    public String getDisplayName() {
        return "Payment Reqired";
    }
}