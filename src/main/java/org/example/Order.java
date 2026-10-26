package org.example;
//Create an Order class containing an order number,
// customer name, total amount, status, payment status, and delivery method.

import java.math.BigDecimal;

import static org.example.PaymentStatus.*;

public class Order {
    private String orderNumber;
    private String customerName;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    public Order(String _orderNumber, String _customerName, BigDecimal _totalAmount,
                 OrderStatus _status, PaymentStatus _paymentStatus, DeliveryMethod _deliveryMethod) {
        this.orderNumber = _orderNumber;
        this.customerName = _customerName;
        this.totalAmount = _totalAmount;
        status = OrderStatus.PREPARING;
        paymentStatus = PaymentStatus.PENDING;
        this.deliveryMethod = _deliveryMethod;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
    public String getCustomerName() {return customerName;}
    public BigDecimal getTotalAmount() {return totalAmount;}
    public OrderStatus getStatus() {return status;}

//Implement methods to:
//Confirm an order only if payment has succeeded.
//Move an order through valid statuses.
//Cancel an order only before it is out for delivery.
//Calculate a delivery fee: collection is free, standard delivery costs R35, and express delivery costs R65.
//Display a readable order summary.

    PaymentStatus ps = PaymentStatus.PENDING;
    DeliveryMethod dm = DeliveryMethod.COLLECTION;
    OrderStatus os = OrderStatus.CANCELLED;
}
