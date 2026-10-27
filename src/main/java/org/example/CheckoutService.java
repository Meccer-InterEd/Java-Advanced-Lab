package org.example;

import java.math.BigDecimal;

public class CheckoutService {

    CardPayment cardPayment = new CardPayment();
    InstantEftPayment instantEftPayment = new InstantEftPayment();
    VoucherPayment voucherPayment = new VoucherPayment();

    public PaymentResult checkout(PaymentMethod paymentMethod,double amount) {

        System.out.println("Payment method: " + PaymentMethod.get);

//        PaymentResult paymentResult = PaymentMethod;
        //return paymentMethod.pay(amount);
    }


}

