package org.example.Interface_Payment_System;

import java.math.BigDecimal;
import java.math.BigInteger;

public class InstantEftPayment implements PaymentMethod{
 BigDecimal balance;
 PaymentResult paymentResult;
    @Override
    public PaymentResult pay(BigDecimal amount) {
        if(amount.compareTo(new BigDecimal(String.valueOf(balance)))>=0){
          return new PaymentResult(true,"AO2-002"," You have failed to make the EFT");

        }
        return new PaymentResult(true,"A02-002"," You have successfully make the IntantEfPayment");

    }


    @Override
    public String getDisplayName() {
        return "Instant EFT Payment";
    }
}
