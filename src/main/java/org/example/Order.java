package org.example;
//Create an Order class containing an order number,
// customer name, total amount, status, payment status, and delivery method.

import javax.swing.*;

import static org.example.PaymentStatus.PAID;
import static org.example.PaymentStatus.PENDING;

public class Order {
    private int orderNumber;
    private String customerName;
    private double totalAmount;
    private String status;
    private String paymentStatus;
    private String deliveryMethod;

    public Order(int _orderNumber, String _customerName, double _totalAmount, String _status, String _paymentStatus, String _deliveryMethod) {
        this.orderNumber = _orderNumber;
        this.customerName = _customerName;
        this.totalAmount = _totalAmount;
        this.status = _status;
        this.paymentStatus = _paymentStatus;
        this.deliveryMethod = _deliveryMethod;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int _orderNumber) {
        this.orderNumber = _orderNumber;
    }
    public String getCustomerName() {return customerName;}
    public void setCustomerName(String _customerName) {
        this.customerName = _customerName;
    }
    public double getTotalAmount() {return totalAmount;}
    public void setTotalAmount(double _totalAmount) {this.totalAmount = _totalAmount;}
    public String getStatus() {return status;}
    public void setStatus(String _status) {this.status = _status;}
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String _paymentStatus) {
        this.paymentStatus = _paymentStatus;
    }
    public String getDeliveryMethod() {
        return deliveryMethod;
    }
    public void setDeliveryMethod(String _deliveryMethod) {
        this.deliveryMethod = _deliveryMethod;
    }

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
