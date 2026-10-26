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
//        totalAmount = totalAmount.add(deliveryMethod.getDeliveryFee());
        if (amount.compareTo(totalAmount) >= 0){
            System.out.println("\nPayment successful!!");
            orderStatus = OrderStatus.CONFIRMED;
            System.out.println("\nOrder "+orderNumber+" has been confirmed!!!");
            Thread.sleep(10000);
//            orderStatus = OrderStatus.PREPARING;
//            System.out.println("\nOrder "+orderNumber+" is getting prepared!!!");
        } else {
            System.out.println("\nPayment failed due to insufficient funds!!! Order costs R"+totalAmount);
        }
    }
}
