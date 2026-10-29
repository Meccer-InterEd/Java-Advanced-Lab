package org.example;

import java.math.BigDecimal;

public class CheckoutService {
private  final  PaymentMethod paymentMethod;



    public CheckoutService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public PaymentResult checkout(BigDecimal amountOwed) {

        if (amountOwed.doubleValue() <= 0){
            System.out.println("Invalid amount");
            return null;
        }
       return paymentMethod.pay(amountOwed);

    }
}
