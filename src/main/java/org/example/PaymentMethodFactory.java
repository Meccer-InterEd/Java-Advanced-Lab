package org.example;

public class PaymentMethodFactory {

    CheckoutService checkoutService = new CheckoutService();

    public static PaymentMethod getPaymentMethod(PaymentType type, double defaultVoucherBalance) {
        if (type == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }

        return switch (type) {
            case CARD_PAYMENT -> new CardPayment();
            case INSTANT_EFT_PAYMENT -> new InstantEftPayment();
            case VOUCHER_PAYMENT -> new VoucherPayment();
        };
    }
    void display() {
        PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(PaymentType.VOUCHER_PAYMENT, 3000);
        PaymentResult result = checkoutService.checkout(paymentMethod, 130);

        System.out.println("Payment Method : " + paymentMethod.getDisplayName());
        System.out.println("Status         : " + (result.successful() ? "SUCCESSFUL" : "FAILED"));
        System.out.println("Reference ID   : " + result.reference());
    }
}
