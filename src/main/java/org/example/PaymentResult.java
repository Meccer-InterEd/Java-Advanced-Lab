package org.example;

public record PaymentResult(boolean successful, String reference , String message) {
}
