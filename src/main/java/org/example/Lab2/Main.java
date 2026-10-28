package org.example.Lab2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        CheckoutService checkout1 = new CheckoutService();
        PaymentMethod voucher = new VoucherPayment(new BigDecimal("100"));
        checkout1.checkout(voucher,new BigDecimal("50"));

        CheckoutService checkout2 = new CheckoutService();
        PaymentMethod voucher2 = new VoucherPayment(new BigDecimal("100"));
        checkout2.checkout(voucher2,new BigDecimal("150"));

        CheckoutService checkout3 = new CheckoutService();
        PaymentMethod card = new CardPayment();
        checkout3.checkout(card,new BigDecimal("500"));

        CheckoutService checkout4 = new CheckoutService();
        PaymentMethod card2 = new CardPayment();
        checkout4.checkout(card2,new BigDecimal("11000"));

        CheckoutService checkout5 = new CheckoutService();
        PaymentMethod eft = new InstantEftPayment();
        checkout5.checkout(eft,new BigDecimal("500"));

        CheckoutService checkout6 = new CheckoutService();
        PaymentMethod eft2 = new InstantEftPayment();
        checkout6.checkout(eft2,new BigDecimal("21000"));



    }
}
