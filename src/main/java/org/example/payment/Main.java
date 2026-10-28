package org.example.payment;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        PaymentMethod voucher  = new VoucherPayment(new BigDecimal("250"));
        PaymentMethod card = new CardPayment(new BigDecimal("1000"));
        PaymentMethod instance = new InstanceEftPayment(new BigDecimal("250"));
        CheckoutService checkout1 = new CheckoutService();
        System.out.println(checkout1.checkout(voucher, new BigDecimal("200")));
        System.out.println(checkout1.checkout(card, new BigDecimal("258")));
        System.out.println(checkout1.checkout(instance, new BigDecimal("2500")));


    }
}
