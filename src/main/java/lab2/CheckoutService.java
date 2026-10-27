package lab2;

import lab2.interfaces.PaymentMethod;
import lab2.records.PaymentResult;

public class CheckoutService {

    public PaymentResult checkout (PaymentMethod paymentMethod , double amount)
    {

        if( amount <= 0)
        {
            throw new IllegalArgumentException("Invalid amount");
        }

        PaymentResult pr = paymentMethod.pay(amount);

        return pr;
    }




}
