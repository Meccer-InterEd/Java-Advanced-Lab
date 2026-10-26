package org.example;

import java.math.BigDecimal;

public class Order {

    private  int orderNumber;
    private String CustomerName;
    private double totalAmt;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    public Order(int orderNumber, String customerName, double totalAmt, DeliveryMethod deliveryMethod) {
        this.orderNumber = orderNumber;
        CustomerName = customerName;
        this.totalAmt = totalAmt;
        this.deliveryMethod = deliveryMethod;
    }

    public PaymentStatus getPaymentStatus() {

    }
}
