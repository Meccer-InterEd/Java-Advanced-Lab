package org.example.Lab2;

import java.math.BigDecimal;

public class InstantEftPayment implements PaymentMethod{

    public static int counter = 200;

    @Override
    public PaymentResult pay(BigDecimal amount){
        if (amount.compareTo(new BigDecimal("20000")) > 0) {

            return new PaymentResult(
                    false,
                    "null",
                    "EFT payment declined.");
        }

        counter++;

        return new PaymentResult(
                true,
                "EFT-" + counter,
                "EFT payment successful.");
    }

    @Override
    public String getDisplayName(){
        return "EFT";
    }
}
