package org.example;

import java.math.BigDecimal;

/*
This is the main project file for Lab 2 activities.
 */
public class PaymentsMain {
    public static void main(String[] args){
        PaymentMethod cardPayment = new CardPayment("John Doe", new BigDecimal("250.00"));
        PaymentMethod eftPayment = new InstantEftPayment("Jane Doe", new BigDecimal("175.00"));
        PaymentMethod voucherPayment = new VoucherPayment("Rick Sanchez", new BigDecimal("900.00"));

        CheckoutService checkoutService = new CheckoutService();

        PaymentResult result1 = checkoutService.checkout(cardPayment,new BigDecimal("290.00"));
        System.out.println(result1.message());
        PaymentResult result2 = checkoutService.checkout(eftPayment,new BigDecimal("68.99"));
        System.out.println(result2.message());
        PaymentResult result3 = checkoutService.checkout(voucherPayment,new BigDecimal("525.99"));
        System.out.println(result3.message());
    }
}
