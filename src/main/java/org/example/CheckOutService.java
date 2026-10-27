package org.example;
import java.math.BigDecimal;
public class CheckOutService {



        public PaymentResult checkout(
                PaymentMethod paymentMethod,
                BigDecimal amount) {


            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                return new PaymentResult(
                        false,
                        "N/A",
                        "Failed: Amount must be greater than zero"
                );
            }


            PaymentResult result = paymentMethod.pay(amount);


            System.out.println("Payment Method: "
                    + paymentMethod.getDisplayName());

            System.out.println("Status: "
                    + (result.successful() ? "Successful" : "Failed"));

            System.out.println("Message: " + result.message());

            System.out.println("Reference: " + result.reference());

            return result;
        }
    }

