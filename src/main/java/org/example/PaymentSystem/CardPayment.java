package org.example.PaymentSystem;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod{

    String cardNumber;


    CardPayment(String cardNmber){

    }

    @Override
    public PaymentResult pay(BigDecimal amount) {

        PaymentResult payment = null;

        return null;
    }

    @Override
    public String getDisplayName() {
        return "";
    }
}
