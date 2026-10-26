package org.example;

import java.math.BigDecimal;

/*
Create an `Order` class containing an order number, customer name,
total amount, status, payment status, and delivery method.
 */
public class Order {
    private String orderNumber;
    private String customerName;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    public Order(String order_number, String customer_name, BigDecimal total_amount, DeliveryMethod
                 delivery_method){
        orderNumber = order_number;
        customerName = customer_name;
        totalAmount = total_amount;
        deliveryMethod = delivery_method;
        orderStatus = OrderStatus.PLACED;
        paymentStatus = PaymentStatus.PENDING;
    }

    public void Pay(BigDecimal amount) throws InterruptedException {
        totalAmount = totalAmount.add(deliveryMethod.getDeliveryFee());
        if (amount.compareTo(totalAmount) >= 0){
            toPaymentStatusPaid("\nPayment successful!!");
            toOrderStatusConfirmed("\nOrder has been confirmed",orderNumber);
            delayExecution(10000);
            toOrderStatusPreparing("\nOrder is being prepared",orderNumber);
        } else {
            toPaymentStatusFailed("\nPayment failed due to insufficient funds!!!");
            toOrderStatusCancelled("\nOrder has been cancelled due to non-payment",orderNumber);
        }

    }

    private void toPaymentStatusPaid(String message){
        paymentStatus = PaymentStatus.PAID;
        System.out.println(message);
    }

    private void toPaymentStatusFailed(String message){
        paymentStatus = PaymentStatus.FAILED;
        System.out.println(message);
    }

    private void toOrderStatusConfirmed(String message, String orderNum){
        orderStatus = OrderStatus.CONFIRMED;
        System.out.println(message+" : Alert for order number "+orderNum);
    }

    private void toOrderStatusPreparing(String message, String orderNum){
        orderStatus = OrderStatus.PREPARING;
        System.out.println(message+" : Alert for order number "+orderNum);
    }

    private void toOrderStatusCancelled(String message, String orderNum){
        orderStatus = OrderStatus.CANCELLED;
        System.out.println(message+" : Alert for order number "+orderNum);
    }

    private void delayExecution(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }
}
