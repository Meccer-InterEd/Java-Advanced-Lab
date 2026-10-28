package org.example.Lab2InterfacePaymentSystem;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("============================================================");
        CheckoutService chServ = new CheckoutService();
        PaymentMethodFactory pmf = new PaymentMethodFactory();

        PaymentMethod voucherP = new VoucherPayment(new BigDecimal("5000"));
        chServ.checkout(voucherP,new BigDecimal("6000"));
        System.out.println(voucherP.summary());
        System.out.println("============================================================");

        PaymentMethod cardP = new CardPayment(new BigDecimal("20"));
        chServ.checkout(cardP,new BigDecimal("20"));
        System.out.println(cardP.summary());
        System.out.println("============================================================");

        PaymentMethod cardPayment = pmf.determinePayMethod(PaymentType.CARD, new BigDecimal("960"));
        chServ.checkout(cardPayment,new BigDecimal("960"));
        System.out.println(cardPayment.summary());


        PaymentMethod eftP = new CardPayment(new BigDecimal("10"));
        chServ.checkout(eftP,new BigDecimal("-1"));
        System.out.println(eftP.summary());
        System.out.println("============================================================");


    }
}
