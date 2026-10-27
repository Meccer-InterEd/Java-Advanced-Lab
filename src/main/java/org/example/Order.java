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
    private BigDecimal amountPaid;

    public Order(String _orderNumber, String _customerName, BigDecimal _totalAmount,
                 BigDecimal amountPaid, DeliveryMethod _deliveryMethod) {
        this.orderNumber = _orderNumber;
        this.customerName = _customerName;
        this.totalAmount = _totalAmount;
        this.amountPaid = amountPaid;
        status = OrderStatus.PREPARING;
        paymentStatus = PaymentStatus.PENDING;
        this.deliveryMethod = _deliveryMethod;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
    public String getCustomerName() {return customerName;}
    public BigDecimal getTotalAmount() {return totalAmount;}
    public BigDecimal setAmountPaid() {return amountPaid;}
    public OrderStatus getStatus() {return status;}

//Implement methods to:
//Confirm an order only if payment has succeeded.
//Move an order through valid statuses.
//Cancel an order only before it is out for delivery.
//Calculate a delivery fee: collection is free, standard delivery costs R35, and express delivery costs R65.
//Display a readable order summary.


    public void confirmOrder() {
        if (amountPaid == null) {
            status = OrderStatus.PLACED;
            paymentStatus = PaymentStatus.PENDING;
            System.out.println("Your order has been placed.");
        } else if (amountPaid.compareTo(totalAmount) == 0) {
            status = OrderStatus.CONFIRMED;
            paymentStatus = PaymentStatus.PAID;
            System.out.println("Order has been confirmed." + "\n Your order number is: " + orderNumber);
        } else {
            PaymentStatus paymentStatus = PaymentStatus.FAILED;
            System.out.println("Order not confirmed, Customer has insufficient funds.");
        }
    }

    public void cancelOrder() {
        if (status != OrderStatus.OUT_FOR_DELIVERY && status != OrderStatus.READY_FOR_COLLECTION && paymentStatus == PaymentStatus.PAID) {
            status = OrderStatus.CANCELLED;
            paymentStatus = PaymentStatus.REFUNDED;
            System.out.println("Order has been cancelled, cancellation fees will be change and You will be Refunded.");
        }  else {
            System.out.println("Order is already out for delivery and collection, CAN NOT CANCEL AT THIS STAGE.");
        }
    }

    public void totalCost() {
        switch (deliveryMethod) {
            case COLLECTION ->  totalAmount = totalAmount.add(totalAmount.add(new BigDecimal("0")));
            case STANDARD_DELIVERY ->   totalAmount = totalAmount.add(totalAmount.add(new BigDecimal("35")));
            case EXPRESS_DELIVERY ->    totalAmount = totalAmount.add(totalAmount.add(new BigDecimal("65")));
        }
        System.out.println("Total Cost with Delivery fee: " + "R" + totalAmount);
    }

    public void info() {
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Amount: " + "R" + totalAmount);
    }

//Challenge
//Add a nextStatus() method that permits only explicitly allowed transitions.
//Do not rely on enum declaration order to decide what comes next.


}
