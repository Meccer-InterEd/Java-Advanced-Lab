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
                 delivery_method) throws InterruptedException {
        orderNumber = order_number;
        customerName = customer_name;
        if (total_amount.intValue() < 0){
            System.out.println("Invalid total_amount value!!! Please try again with a positive value.");
            delayExecution(5000);
            System.exit(0);
        }
        totalAmount = total_amount;
        deliveryMethod = delivery_method;
        orderStatus = OrderStatus.PLACED;
        paymentStatus = PaymentStatus.PENDING;
    }

    public void Pay(BigDecimal amount) throws InterruptedException {
        totalAmount = totalAmount.add(deliveryMethod.getDeliveryFee());
        if (amount.compareTo(totalAmount) >= 0){
            paymentPaid("\nPayment successful!!");
            orderConfirmed("\nOrder has been confirmed",orderNumber);
            delayExecution(5000);
            orderPreparing("\nOrder is being prepared",orderNumber);
            orderProgress();
        } else {
            paymentFailed("\nPayment failed due to insufficient funds!!!");
            orderCancelled("\nOrder has been cancelled due to non-payment",orderNumber);
        }
    }

    private void paymentPaid(String message){
        paymentStatus = PaymentStatus.PAID;
        System.out.println(message);
    }

    private void paymentFailed(String message){
        paymentStatus = PaymentStatus.FAILED;
        System.out.println(message);
    }

    private void orderConfirmed(String message, String orderNum){
        orderStatus = OrderStatus.CONFIRMED;
        System.out.println(message+" : Alert for order number "+orderNum);
    }

    private void orderPreparing(String message, String orderNum){
        orderStatus = OrderStatus.PREPARING;
        System.out.println(message+" : Alert for order number "+orderNum);
    }

    private void orderCancelled(String message, String orderNum){
        orderStatus = OrderStatus.CANCELLED;
        System.out.println(message+" : Alert for order number "+orderNum);
    }

    private void orderReadyForCollection(String message, String orderNum){
        orderStatus = OrderStatus.READY_FOR_COLLECTION;
        System.out.println(message+" : Alert for order number "+orderNum+"\n\n");
    }

    private void orderOutForDelivery(String message, String orderNum){
        orderStatus = OrderStatus.OUT_FOR_DELIVERY;
        System.out.println(message+" : Alert for order number "+orderNum);
    }

    private void orderDelivered(String message, String orderNum){
        orderStatus = OrderStatus.DELIVERED;
        System.out.println(message+" : Alert for order number "+orderNum+"\n\n");
    }

    private void delayExecution(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    private void orderProgress() throws InterruptedException {
        if (deliveryMethod == DeliveryMethod.COLLECTION){
            delayExecution(7000);
            orderReadyForCollection("\nThe order is ready for collection",orderNumber);
        } else if (deliveryMethod == DeliveryMethod.STANDARD_DELIVERY){
            delayExecution(7000);
            orderOutForDelivery("\nThe order is out for delivery",orderNumber);
            delayExecution(7000);
            orderDelivered("\nOrder delivered",orderNumber);
        } else {
            delayExecution(5000);
            orderOutForDelivery("\nThe order is out for delivery",orderNumber);
            delayExecution(4000);
            orderDelivered("\nOrder delivered",orderNumber);
        }
    }
}
