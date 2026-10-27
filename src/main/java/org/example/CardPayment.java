package org.example;
//Each implementation must apply its own rules.
//For example, a voucher payment should reject an amount greater than the voucher balance.
//The card and EFT implementations can simulate success or failure; do not connect to real payment services.

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod {
     String cardNumber;
     String cardHolderName;
     BigDecimal balance;
    private String displayName;


    public CardPayment(String cardNumber, String cardHolderName, BigDecimal balance) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.balance = balance;
    }
    @Override
    public String getDisplayName() {
        return "";
    }
    @Override
    public PaymentResult pay(BigDecimal amount) {
        return null;
    }
}
