package org.example;
//Create an Order class containing an order number,
// customer name, total amount, status, payment status, and delivery method.

import java.math.BigDecimal;

public class Order {
    private String orderNumber;
    private String customerName;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    public Order(String _orderNumber, String _customerName, BigDecimal _totalAmount, DeliveryMethod _deliveryMethod) {
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


    public void confirmOrder() {
        if (status == OrderStatus.CONFIRMED && paymentStatus == PaymentStatus.PAID) {
            System.out.println("Order has been confirmed");
        } else  {
            System.out.println("Order hasn't been confirmed");
        }
    }

    public void cancelOrder() {
        if (status == OrderStatus.CANCELLED && paymentStatus == PaymentStatus.PAID) {
            System.out.println("Order has been cancelled");
        }  else {
            System.out.println("Order is already out for delivery, CAN NOT CANCEL AT THIS STAGE.");
        }
    }
    public void totalCost() {
        if(deliveryMethod == DeliveryMethod.COLLECTION) {
            totalAmount = totalAmount.add(new BigDecimal("0"));
        }  else if(deliveryMethod == DeliveryMethod.STANDARD_DELIVERY) {
            totalAmount = totalAmount.add(new BigDecimal("35"));
        }else{
            totalAmount = totalAmount.add(new BigDecimal("65"));
        }
        System.out.println("Total Cost with delivery fee: " + "R" + totalAmount);
    }

    public void info() {
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Amount: " + totalAmount);
    }
}
