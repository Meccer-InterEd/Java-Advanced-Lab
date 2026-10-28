package org.example.PaymentSystem;

import java.math.BigDecimal;

public class CheckoutService{





    public PaymentResult checkout(PaymentMethod paymentMethod, BigDecimal amount){

    return  paymentMethod.pay(amount) ;
    }
}
