package org.example;

public record PaymentResult() {
    static boolean successful;
    static String reference;
    static String message;
}
