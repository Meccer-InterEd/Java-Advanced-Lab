package org.example.Lab02_Interface_Payment_System;

import java.math.BigDecimal;

public interface PaymentMethod {
        PaymentResult pay(BigDecimal amount);
        String getDisplayName();
}
