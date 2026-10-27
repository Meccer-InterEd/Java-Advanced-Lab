package org.example;

import java.math.BigDecimal;

public interface PaymentMethod {
    PaymentResult pay(BigDecimal amount);
    String getDisplayName();
    default boolean isAmountValid(BigDecimal amount){
        if (amount.doubleValue() <= 0.0){
            System.out.println("\nInvalid input. Amount cannot be 0 or less!");
            return false;
        }
        return true;
    }
}
