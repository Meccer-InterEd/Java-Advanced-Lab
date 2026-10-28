package org.example;

public class Main {
    public static void main(String[] args) {


        CheckoutService checkoutService = new CheckoutService();

        PaymentMethod card = new CardPayment("Capitec", 250);
        PaymentMethod eft = new InstantEftPayment("Absa", 250);
        PaymentMethod voucher = new VoucherPayment("VC-001", 250);

        checkoutService.checkout(card, 150);
        checkoutService.checkout(eft, 100);
        checkoutService.checkout(voucher, 250);

    }
}