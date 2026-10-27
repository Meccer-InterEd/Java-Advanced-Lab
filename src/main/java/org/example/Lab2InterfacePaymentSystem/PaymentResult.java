package org.example.Lab2InterfacePaymentSystem;

import java.math.BigDecimal;

public record PaymentResult(boolean successful,String reference,String message) {

}
