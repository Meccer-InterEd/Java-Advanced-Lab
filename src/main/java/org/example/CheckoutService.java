package org.example;

public class CheckoutService {


    PaymentResult checkout (double amount, PaymentMethod payment){
        PaymentResult result = payment.pay(amount);

        System.out.println("Payment method: " + payment.getDisplayName());
        System.out.println("Amount due: R" + amount);
        System.out.println("Payment Successful?: " + result.successful());
        System.out.println("Reference: " + result.reference());
        System.out.println("Message: " + result.message());
        System.out.println("---------------------------------------------------------------");
        return payment.pay(amount);

    }

}

