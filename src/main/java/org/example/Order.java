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
    private BigDecimal finalAmount;
    private BigDecimal deliveryFee;
    private boolean isOrderCanceled;

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
        isOrderCanceled = false;
    }

    public void Pay(BigDecimal amount) throws InterruptedException {
        deliveryFee = deliveryMethod.getDeliveryFee();
        finalAmount = totalAmount.add(deliveryFee);
        if (amount.compareTo(totalAmount) >= 0){
            paymentPaid("\nPayment successful!!");
            orderConfirmed("\nOrder has been confirmed",orderNumber);
            delayExecution(5000);
            orderPreparing("\nOrder is being prepared",orderNumber);
            delayExecution(5000);
//            orderProgress();
        } else {
            paymentFailed("\nPayment failed due to insufficient funds!!!");
            orderCancelled("\nOrder has been cancelled due to non-payment",orderNumber);
        }
    }

    public void cancelOrder() throws InterruptedException {
        if (orderStatus == OrderStatus.READY_FOR_COLLECTION){
            System.out.println("\nOrder cannot be cancelled at this moment! As it is ready for collection.");

        } else if (orderStatus == OrderStatus.OUT_FOR_DELIVERY || orderStatus == OrderStatus.DELIVERED){
            System.out.println("\nOrder cannot be cancelled at this moment! As it is out for delivery / has been delivered.");
        } else {
            orderCancelled("\n"+customerName+" has cancelled their order!!!",orderNumber);
        }
    }

    private void orderSummary(){
        System.out.println("============Order Summary============");
        System.out.println("Customer Name: "+customerName);
        System.out.println("Order Number: "+orderNumber);
        System.out.println("Order Payment Status: "+paymentStatus);
        System.out.println("Order Status: "+orderStatus);
        System.out.println("Order Delivery Method: "+deliveryMethod);
        System.out.println("--------------------------------------");
        System.out.println("Order Items Cost Price: "+totalAmount);
        System.out.println("Delivery Fee: "+deliveryFee);
        System.out.println("Final Cost: "+finalAmount);
        System.out.println("--------------------------------------");
    }

    private void paymentPaid(String message) throws InterruptedException {
        paymentStatus = PaymentStatus.PAID;
        System.out.println(message);
        orderSummary();
        delayExecution(5000);
    }

    private void paymentFailed(String message) throws InterruptedException {
        paymentStatus = PaymentStatus.FAILED;
        System.out.println(message);
        orderSummary();
        delayExecution(5000);
    }

    private void orderConfirmed(String message, String orderNum) throws InterruptedException {
        orderStatus = OrderStatus.CONFIRMED;
        System.out.println(message+" : Alert for order number "+orderNum);
        orderSummary();
        delayExecution(5000);
    }

    private void orderPreparing(String message, String orderNum) throws InterruptedException {
        orderStatus = OrderStatus.PREPARING;
        System.out.println(message+" : Alert for order number "+orderNum);
        orderSummary();
        delayExecution(5000);
    }

    private void orderCancelled(String message, String orderNum) throws InterruptedException {
        orderStatus = OrderStatus.CANCELLED;
        isOrderCanceled = true;
        System.out.println(message+" : Alert for order number "+orderNum);
        orderSummary();
        delayExecution(5000);
    }

    private void orderReadyForCollection(String message, String orderNum) throws InterruptedException {
        orderStatus = OrderStatus.READY_FOR_COLLECTION;
        System.out.println(message+" : Alert for order number "+orderNum+"\n\n");
        orderSummary();
        delayExecution(5000);
    }

    private void orderOutForDelivery(String message, String orderNum) throws InterruptedException {
        orderStatus = OrderStatus.OUT_FOR_DELIVERY;
        System.out.println(message+" : Alert for order number "+orderNum);
        orderSummary();
    }

    private void orderDelivered(String message, String orderNum) throws InterruptedException {
        orderStatus = OrderStatus.DELIVERED;
        System.out.println(message+" : Alert for order number "+orderNum);
        orderSummary();
        delayExecution(5000);
    }

    private void delayExecution(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    public void orderProgress() throws InterruptedException {
        if (!isOrderCanceled){
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
}
