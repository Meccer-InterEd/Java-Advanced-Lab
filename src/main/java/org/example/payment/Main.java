package org.example.payment;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        PaymentMethod voucher  = new VoucherPayment();
        CheckoutService hello = new CheckoutService();
        hello.checkout(voucher, new BigDecimal("200"));

    }
}
