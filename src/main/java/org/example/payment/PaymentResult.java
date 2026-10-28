package org.example.payment;

public record PaymentResult(boolean successful, String reference, String message) {
}
