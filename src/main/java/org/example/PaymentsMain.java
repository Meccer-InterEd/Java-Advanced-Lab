package org.example;

import java.math.BigDecimal;

/*
This is the main project file for Lab 2 activities.
 */
public class PaymentsMain {
    public static void main(String[] args){
        PaymentMethod cardPayment = PaymentMethodFactory.manufacturePaymentMethod(
                PaymentType.CARD_PAYMENT,
                "John Doe",
                new BigDecimal("350.00")
        );

        PaymentMethod eftPayment = PaymentMethodFactory.manufacturePaymentMethod(
                PaymentType.INSTANT_EFT_PAYMENT,
                "Jane Doe",
                new BigDecimal("175.00")
        );

        PaymentMethod voucherPayment = PaymentMethodFactory.manufacturePaymentMethod(
                PaymentType.VOUCHER_PAYMENT,
                "Rick Sanchez",
                new BigDecimal("900.00")
        );

        CheckoutService checkoutService = new CheckoutService();

        PaymentResult result1 = checkoutService.checkout(cardPayment,new BigDecimal("290.00"));
        System.out.println(result1.message());

        PaymentResult result2 = checkoutService.checkout(eftPayment,new BigDecimal("68.99"));
        System.out.println(result2.message());

        PaymentResult result3 = checkoutService.checkout(voucherPayment,new BigDecimal("525.99"));
        System.out.println(result3.message());
    }
}
