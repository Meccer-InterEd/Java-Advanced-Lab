package org.example;

public class CheckoutService {
    public PaymentResult checkout(PaymentMethod paymentMethod, double amount) {

        if (amount <= 0) {

            PaymentResult failedPayment = new PaymentResult(false, "", "Payment failed!The amount due cannot be zero or less");

            return failedPayment;
        }

        PaymentResult successPayment = paymentMethod.pay(amount);

        printSummary(paymentMethod, successPayment);
        return successPayment;
    }

    void printSummary(PaymentMethod method, PaymentResult result){

        System.out.println("===================================================================");
        System.out.println("Payment method : " + method.getDisplayName());
        System.out.println("Status : " + result.successful());
        System.out.println("Reference : " + result.reference());
        System.out.println("Message : " + result.message());
    }
}
