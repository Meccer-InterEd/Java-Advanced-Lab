package org.example.PaymentSystem;

public record PaymentResult(boolean successful, String reference, String message) {
}
