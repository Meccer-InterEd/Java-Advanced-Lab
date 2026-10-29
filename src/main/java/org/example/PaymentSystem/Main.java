package org.example.PaymentSystem;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        CheckoutService c = new CheckoutService();

    Voucher voucher = new Voucher("1234567","2222222",new BigDecimal("-50.00"));
    InstantEFT EFT = new InstantEFT("12323344","Thamsanqa",new BigDecimal("-450.00"));
    CardPayment card = new CardPayment("55683635683","Thamsanqa", new BigDecimal("700.00"));

        System.out.println("Enter amount to pay?");
    BigDecimal amountToPay=  sc.nextBigDecimal();

        PaymentMethod method1 = voucher;
        PaymentMethod method2 = EFT;
        PaymentMethod method3 = card;

        System.out.println("Pick 1 - 3 payment method: \n1.Voucher\n2.EFT\n3.Card Payment");
        int paymentMethod = sc.nextInt();




    switch(paymentMethod){
        case 1 :
            System.out.println(c.checkout(method1,amountToPay).message());
            break;

        case 2 :
            System.out.println(c.checkout(method2,amountToPay).message());
            break;

        case 3 :

            System.out.println(c.checkout(method3,amountToPay).message());
            break;

        default : throw  new IllegalArgumentException("Input number from 1-3 Redirecting");

    }



    }
}
