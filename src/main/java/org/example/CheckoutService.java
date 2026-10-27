package org.example;

public class CheckoutService {

    public PaymentResult checkout(PaymentMethod paymentMethod, double amount) {
        return paymentMethod.pay(amount);
    }
}
