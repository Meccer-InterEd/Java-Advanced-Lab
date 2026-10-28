package org.example.PaymentSystem;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){

        CheckoutService c = new CheckoutService();

    Voucher card = new Voucher("1234567","2222222",new BigDecimal("50.00"));
    BigDecimal amountToPay=  new BigDecimal("100.10");


    PaymentMethod method = card;


        System.out.println(c.checkout(method,amountToPay).message());

    }
}
