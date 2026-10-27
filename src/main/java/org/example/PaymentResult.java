package org.example;

public record PaymentResult(boolean successful, String reference, String message) {

    public void CardPayment() {

    }
    public void InstantEftPayment() {

    }
    public void VoucherPayment() {

    }
}
