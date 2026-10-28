
package org.example;

import java.math.BigDecimal;

public class CheckOutService {

    public PaymentResult checkout(PaymentMethod paymentMethod, BigDecimal amount) {

        if (paymentMethod == null) {
            return new PaymentResult(
                    false,
                    "ERR-1001",
                    "Payment method cannot be null"
            );
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return new PaymentResult(
                    false,
                    "ERR-1002",
                    "Payment amount must be greater than zero"
            );
        }

        PaymentResult result = paymentMethod.pay(amount);

        System.out.println("Payment Method: " + paymentMethod.getDisplayName());
        System.out.println("Amount: R" + amount);
        System.out.println("Payment Status: " +
                (result.successful() ? "Successful" : "Failed"));
        System.out.println("Reference: " + result.reference());
        System.out.println("Message: " + result.message());

        return result;
    }
}


