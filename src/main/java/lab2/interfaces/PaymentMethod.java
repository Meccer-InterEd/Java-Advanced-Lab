package lab2.interfaces;

import lab2.records.PaymentResult;

public interface PaymentMethod {

        PaymentResult pay(double amount);
        String displayName();

}
