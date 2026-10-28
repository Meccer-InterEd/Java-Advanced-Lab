package org.example.Lab2InterfacePaymentSystem;

import org.example.Lab1FoodDeliveryOrder.PaymentStatus;

import java.math.BigDecimal;

public class CheckoutService {
    public PaymentResult checkout(PaymentMethod paymentMethod, BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount is used here, amount can not be a negative");
        }
        PaymentResult pr = paymentMethod.pay(amount);
        System.out.println("Payment is being processed via:" + paymentMethod.getDisplayName());
        return pr;
    }


}
