package org.example;

import java.math.BigDecimal;

public record PaymentResult(boolean successful, String reference, String message) {

}
